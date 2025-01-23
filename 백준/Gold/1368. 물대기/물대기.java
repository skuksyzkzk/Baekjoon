import java.util.*;
import java.io.*;

class Main {
    public static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] well = new int[N];

        // 우물 비용 입력
        for (int i = 0; i < N; i++) {
            well[i] = Integer.parseInt(br.readLine());
        }

        // 간선 비용 입력
        ArrayList<Node>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i != j) {
                    adj[i].add(new Node(j, cost));
                }
            }
        }

        // 프림 알고리즘을 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        int totalCost = 0;

        // 가상의 노드에서 모든 논으로 가는 비용 추가
        for (int i = 0; i < N; i++) {
            pq.add(new Node(i, well[i]));
        }

        // MST 구성
        int connected = 0;
        while (connected < N) {
            Node cur = pq.poll();

            if (visited[cur.to]) continue;
            visited[cur.to] = true;
            totalCost += cur.cost;
            connected++;

            // 현재 논과 연결된 간선 추가
            for (Node next : adj[cur.to]) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(totalCost);
    }
}
