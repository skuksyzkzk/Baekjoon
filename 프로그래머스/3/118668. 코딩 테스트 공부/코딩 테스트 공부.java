import java.util.*;

class Solution {
    static int[][] dp; // 해당 알고력과 코딩력을 얻기위한 최단시간 
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = alp; int maxCop = cop;
        for (int[] pb : problems){
            maxAlp = Math.max(pb[0],maxAlp);
            maxCop = Math.max(pb[1],maxCop);
        }
        
        dp = new int[maxAlp+1][maxCop+1];
        for (int i = 0 ; i <= maxAlp;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= maxAlp; i++){
            for (int j = cop; j <= maxCop; j++){
                // 기본 알고력 , 코딩력 올리기 +1씩 
                if (i+1 <= maxAlp){
                    dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                }
                if (j+1 <= maxCop){
                    dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                }
                // 만약 문제를 풀 수있다면 풀기 
                for (int[] pb : problems){
                    int alpReq = pb[0]; int copReq = pb[1];
                    int alpRwd = pb[2]; int copRwd = pb[3];
                    int time = pb[4];
                    if (i >= alpReq && j >= copReq){
                        int newAlp = Math.min(maxAlp,i + alpRwd);
                        int newCop = Math.min(maxCop,j + copRwd);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], 
                                                      dp[i][j] + time);
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}