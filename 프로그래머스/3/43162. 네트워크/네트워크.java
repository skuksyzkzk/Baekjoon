import java.util.*;

class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] adj;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        adj = new ArrayList[n];
        for (int i = 0; i< n ; i++){
            adj[i] = new ArrayList<>();
        }
        for (int i = 0 ;i <n-1;i++){
            for (int j = i+1; j<n; j++){
                if (computers[i][j] == 1){
                    adj[i].add(j);
                    adj[j].add(i); 
                }
                
            }
        }
        visited = new boolean[n];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0 ; i <n ; i++){
            q.offer(i);
        }
      
        while(!q.isEmpty()){
            int cur = q.poll();
            if (visited[cur]) continue;
            else {
                answer++;
                bfs(cur);
            }
        }
        return answer;
    }
    private static void bfs(int start){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        
        while(!stack.isEmpty()){
            int cur = stack.pop();
            visited[cur] = true;
            System.out.println(cur);
            for (int next : adj[cur]){
                if(!visited[next]){
                    stack.push(next);
                }
            }
        }
    }
}