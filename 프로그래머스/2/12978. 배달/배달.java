import java.util.*;
// 노드 클래스 - 인터페이스로 비교(최단거리 기준 )
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
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 우선순위 큐 -> 주변 노드를 푸시하지만 최단거리 순 
        ArrayList<Node>[] adj = new ArrayList[N+1];
        for (int i = 0;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] i : road){
            adj[i[0]].add(new Node(i[1],i[2]));
            adj[i[1]].add(new Node(i[0],i[2]));
        }
        // dist의 배열에 거리 보다 큐 poll한게 크다 그러면 이미 결정된 최단거리 이므로 넘김
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<Node> pq  = new PriorityQueue<>();
        pq.offer(new Node(1,0));
        //거리를 초기화 = 기존 거리 > 해당 노드까지 + 노드 코스트, 큐에 푸시 (왜냐 간선이니까)
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if (dist[cur.dest] < cur.cost) continue;
            
            for (Node node : adj[cur.dest]){
                if (dist[node.dest] > dist[cur.dest] + node.cost){
                    dist[node.dest] = dist[cur.dest] + node.cost;
                    pq.offer(new Node(node.dest,dist[node.dest]));
                }
            }
        }
        // dist 순회하면서 k보다 작은거 count 
        for (int i = 1 ; i<=N; i++){
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
}