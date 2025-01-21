import java.util.*;

class Solution {
    public static class Node {
        int number, sheep, wolf;
        HashSet<Integer> adj; // 인접한 노드들 저장
        
        public Node (int number,int sheep,int wolf, HashSet<Integer> adj){
            this.number = number;
            this.sheep = sheep;
            this.wolf = wolf;
            this.adj = adj; 
        }
    }
    public static ArrayList<Integer>[] tree;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        // 트리 생성 
        tree = new ArrayList[info.length];
        for (int i = 0 ; i < info.length; i++){
            tree[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < edges.length;i++){
            tree[edges[i][0]].add(edges[i][1]);
        }
        // BFS 
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offerLast(new Node(0,1,0,new HashSet<>()));
        
        while (!q.isEmpty()){
            Node cur = q.pollFirst();
            answer = Math.max(answer,cur.sheep);
            // 인접한 노드들 추가 
            cur.adj.addAll(tree[cur.number]);
       
            for (int next : cur.adj){
                HashSet<Integer> set = new HashSet<>(cur.adj);
                // 사실 상 한번 방문한 것이므로 set에서 제거해서 넘겨줘야된다.
                set.remove(next);
                // 늑대일 경우 
                if (info[next] == 1 && cur.sheep > cur.wolf + 1) 
                    q.offerLast(new Node(next,cur.sheep,cur.wolf+1,set));
                // 양일 경우
                else if (info[next] == 0) 
                    q.offerLast(new Node(next,cur.sheep+1,cur.wolf,set));
            
            }
        }
         
        return answer;
    }
}