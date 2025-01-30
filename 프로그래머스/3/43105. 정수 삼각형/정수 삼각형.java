import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length+1];
        dp[0][1] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < 2 + i; j++){
                dp[i][j] = triangle[i][j-1] + Math.max( dp[i-1][j-1],dp[i-1][j] );                
            }
        }
        
        return Arrays.stream(dp[triangle.length-1]).max().getAsInt() ;

    }
}