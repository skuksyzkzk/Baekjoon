import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1234;
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N][M];
        
        for (int i = 0; i < M;i ++){
            dp[0][i] = board[0][i];
        }
        for (int i = 0 ; i < N; i++){
            dp[i][0] = board[i][0];
        }
        for (int x = 1; x < N; x++) {
            for (int y = 1; y < M; y++){
                if (board[x][y] == 1 ){
                    if (board[x-1][y-1] == 1 && board[x-1][y] == 1 && board[x][y-1] == 1){
                        dp[x][y] = Math.min(dp[x-1][y-1],Math.min(dp[x-1][y],dp[x][y-1]))+1;
                    }else{
                        dp[x][y] = 1;
                    }
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < N; i++){
            maxValue = Math.max(maxValue,Arrays.stream(dp[i]).max().getAsInt());
        }
        return maxValue * maxValue;
    }
}