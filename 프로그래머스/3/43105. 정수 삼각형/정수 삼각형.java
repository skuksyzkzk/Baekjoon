import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int[][] dp = new int[N+1][N+1];
        int[][] board = new int[N+1][N+1];
        
        for (int i = 0; i < N;i++){
            for (int j = 0; j < triangle[i].length;j++ ){
                board[i+1][j+1] = triangle[i][j];
            }
        }
        dp[1][1] = board[1][1];
        for (int i = 2; i <= N ; i++){
            for (int j = 1; j<=N;j++){
                dp[i][j] = board[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        
        return Arrays.stream(dp[N]).max().getAsInt();
    }
}