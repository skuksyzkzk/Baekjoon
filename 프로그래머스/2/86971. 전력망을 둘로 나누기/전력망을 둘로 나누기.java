import java.util.*;

class Solution {
    static boolean[] visited;
    static int count;
    static ArrayList<Integer>[] adj;
    
    public void dfs(int now ){
        if (visited[now]) return;
        visited[now] = true;
        count++;
        for (int next : adj[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
        
    }
    public int solution(int n, int[][] wires) {
        int answer = n-1;
        // 우선  for문으로 하나씩 wires 확인해서 1 3 이면 1 3 저장 
        // 1 - 3 을 빼고 나머지로 트리를 연결한뒤 1 3 에서 dfs 시작 
        for (int i = 0; i<wires.length;i++){
            int first = wires[i][0];
            int second = wires[i][1];
            
            visited = new boolean[n+1];
            count = 0;
            adj = new ArrayList[n+1];
            for (int j = 0; j <= n; j++ ){
                adj[j] = new ArrayList<>();
            }
            for (int j = 0 ; j< wires.length;j++){
                if (j == i) continue;
                adj[wires[j][0]].add(wires[j][1]);
                adj[wires[j][1]].add(wires[j][0]);
            }
            dfs(first);
            int subTree = count;
            int remainTree = n - count;
            answer = Math.min(answer,Math.abs(remainTree - subTree));
        }
                
        
        return answer;
    }
}