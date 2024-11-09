import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int[][] computer;
    private static void bfs(int start){
        visited[start] = true;
        
        for (int i = 0; i < computer[start].length;i++){
            if (computer[start][i] == 1 && !visited[i]){
                bfs(i);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        computer =computers;
        
        for (int i = 0; i<n;i++){
            if(!visited[i]){
                answer++;
                bfs(i);
            }
        }
        
        return answer;
    }
}