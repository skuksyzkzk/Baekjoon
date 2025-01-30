import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++){
            for (int j = 0; j < 4; j++){
                dp[i][j] = land[i][j] + Math.max(dp[i-1][(j+1) % 4], 
                        Math.max(dp[i-1][(j+2) % 4],dp[i-1][(j+3) % 4]));
            }
        }

        return Arrays.stream(dp[land.length-1]).max().getAsInt();
    }
}