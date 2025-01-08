import java.util.*;

class Solution {
    class Node  implements Comparable<Node> {
        int dest,cost;
        public Node (int dest,int cost){
            this.dest = dest;
            this.cost = cost;
        }
        
        @Override 
        public int compareTo(Node other){
            return Integer.compare(this.cost,other.cost);
        }
        
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 1번에서 다익스트라로 가는 경로 비용이 K 만큼보다 작아야되는거니까
        // 다익스트라 한번 해서 비용 갱신하고 거기서 K보다 작은거 확인
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList<Node>[] adj = new ArrayList[N+1];
        for (int i = 0 ; i<= N; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0 ; i<road.length;i++){
            adj[road[i][0]].add(new Node(road[i][1],road[i][2]));
            adj[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }
        // 다익스트라 과정 
        // 한 지점에서 최솟값으로 우선순위큐로 해서 제일 최소 비용인 간선기준 
        // 현재 코스트가 해당 지점의 cost보다 작으면 무시 
        // 현재 코스트가 cur cost + 라인의 cost 보다 작으면 이 역시 무시 
        // 아닐 경우 코스트를 위의 값으로 갱신 
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (dist[cur.dest] < cur.cost) continue;
            
            for (Node next : adj[cur.dest]){
                if (dist[next.dest] > cur.cost + next.cost) {
                    dist[next.dest] = cur.cost + next.cost;
                    pq.add(new Node(next.dest,dist[next.dest]));
                }
            }
        }
        
        for (int i = 0; i <= N; i++){
            if (dist[i] <= K){
                answer++;
            }
        }

        return answer;
    }
}