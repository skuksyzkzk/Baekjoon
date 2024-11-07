
import java.util.*;
import java.io.*;
class Node implements Comparable<Node> {
    int dest,cost;
    public Node(int dest,int cost){
        this.dest = dest;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node other){
        return Integer.compare(this.cost,other.cost);
    }
}
class Main {
    private static int v,e,start;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        ArrayList<Node>[] adjList = new ArrayList[v+1];
        for (int i = 0 ; i<= v ; i++){
            adjList[i] = new ArrayList<>();
        }

        for ( int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());

            int source = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[source].add(new Node(dest,cost));
        }

        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (dist[cur.dest] < cur.cost) continue;

            for (Node node : adjList[cur.dest]){
                if (dist[node.dest] > cur.cost + node.cost){
                    dist[node.dest] = cur.cost + node.cost;
                    pq.offer(new Node(node.dest,dist[node.dest]));
                }
            }
        }
        int flag = 1;
        for (int i : dist){
            if (flag == 1){
                flag = 2;
                continue;
            }
            if (i == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(i);
        }
    }
}