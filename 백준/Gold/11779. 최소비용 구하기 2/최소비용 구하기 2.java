
import java.util.*;
import java.io.*;

public class Main{
    static class Node implements Comparable<Node>{
        int dest,cost;
        public Node(int dt,int ct){
            this.dest = dt;
            this.cost = ct;
        }
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.cost,other.cost);
        }
    }
    static int n,m;
    static int start,end;
    static ArrayList<Node>[] adj;
    static PriorityQueue<Node> pq;
    static int[] dist;
    static int[] pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n+1];

        for (int i = 0; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[source].add(new Node(dest,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        pre = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pre[start] = start;

        pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (dist[cur.dest] < cur.cost) continue;
            for (Node node : adj[cur.dest]){
                if (dist[node.dest] > dist[cur.dest] + node.cost){
                    dist[node.dest] = dist[cur.dest] + node.cost;
                    pq.offer(new Node(node.dest,dist[node.dest]));
                    pre[node.dest] = cur.dest;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb.append(dist[end]).append("\n");
        int count = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(end);
        while(pre[end] != start){
            stack.push(pre[end]);
            end = pre[end];
        }
        stack.push(start);
        while (!stack.isEmpty()){
            count++;
            int temp = stack.pop();
            sb2.append(temp+" ");
        }
        sb.append(count).append("\n").append(sb2);
        System.out.println(sb);
    }
}