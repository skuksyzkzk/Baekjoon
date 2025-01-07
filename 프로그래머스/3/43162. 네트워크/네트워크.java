import java.util.*;

class Solution {
    static int answer = 0;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        // adj 리스트로 무방향 그래프 형성하기 
        adj = new ArrayList[n];
        visited = new boolean[n];
        for (int i =0 ; i< n;i++){
            adj[i] = new ArrayList<>();
        }
        // 노드갯수만큼 반복해서 방문하지않는 경우 dfs시작한뒤 dfs실행한 갯수를 체크하기 
        for (int i = 0; i<n;i++){
            for (int j = i+1; j < n; j++){
                if (computers[i][j] == 1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        for (int i= 0; i< n;i++){
            if (!visited[i]){
                answer++;
                dfs(i);  
            } 
        }
        return answer;
    }
    public void dfs(int now){
        visited[now] = true;
        for (int next : adj[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}