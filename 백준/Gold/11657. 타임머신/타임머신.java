
import java.util.*;
import java.io.*;

class Node {
    int dest, cost;
    public Node(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기화
        ArrayList<Node>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[source].add(new Node(dest, cost));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        // v-1 번 반복해서 간선 업데이트
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= n; j++) {
                for (Node node : adjList[j]) {
                    if (dist[j] != Integer.MAX_VALUE && dist[node.dest] > dist[j] + node.cost) {
                        dist[node.dest] = dist[j] + node.cost;
                    }
                }
            }
        }

        // 한번 더 반복해서 값이 변했으면 -1 즉 음의 사이클 존재
        boolean hasNegativeCycle = false;
        outer:
        for (int j = 1; j <= n; j++) {
            for (Node node : adjList[j]) {
                if (dist[j] != Integer.MAX_VALUE && dist[node.dest] > dist[j] + node.cost) {
                    System.out.println("-1");
                    hasNegativeCycle = true;
                    break outer;  // 음의 사이클 발견 시 바로 종료
                }
            }
        }

        // 음의 사이클이 없으면 결과 출력
        if (!hasNegativeCycle) {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.print(sb);
        }
    }
}
