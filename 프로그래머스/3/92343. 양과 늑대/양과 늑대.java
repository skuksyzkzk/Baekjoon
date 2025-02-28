import java.util.*;

class Solution {
    class Node {
        int sheep, wolf, dest;
        HashSet<Integer> notVisited;
        
        public Node (int sheep, int wolf, int dest,HashSet<Integer> notVisited){
            this.sheep = sheep;
            this.wolf = wolf;
            this.dest = dest;
            this.notVisited = notVisited;
        }
    }
    static ArrayList<Integer>[] adj;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0; 
        adj = new ArrayList[info.length];
        
        for (int i = 0 ; i < info.length; i++){
            adj[i] = new ArrayList<>();
        }
        
        for (int[] e : edges){
            adj[e[0]].add(e[1]);
        }
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(1,0,0,new HashSet<>()));
        
        while (!q.isEmpty()){
            Node cur = q.poll();
            // 뽑았으면 그거와 답을 비교한다. 들어왔다는 것 자체가 양의 수가 많다는 것.
            answer = Math.max(answer,cur.sheep);
            // 해당 간선을 추가해야됨 인접한 
            cur.notVisited.addAll(adj[cur.dest]);
            
            for (int next : cur.notVisited){
                HashSet<Integer> newSet = new HashSet<>(cur.notVisited);
                newSet.remove(next);
                // 거기로 가면 양 <= 늑대면 가면 안됨 
                // 거기가 늑대면 
                if (info[next] == 1){
                    if (cur.sheep <= cur.wolf + 1) continue;
                    q.offer(new Node(cur.sheep,cur.wolf+1,next,newSet));
                }
                // 양이면 
                else {
                    q.offer(new Node(cur.sheep+1,cur.wolf,next,newSet));
                }
            }
        }
        return answer;
    }
}