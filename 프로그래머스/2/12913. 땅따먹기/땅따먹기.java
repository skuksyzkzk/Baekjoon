import java.util.*;

class Solution {
    int solution(int[][] land) {
       
        int N = land.length;
        int [][] dp = new int[N][4];
        // 자신 위치 제외하고 저장할 공간 3이고 
        // 첫번째 줄만 갱신 해준다
        for (int i = 0; i< 4;i++){
            dp[0][i] = land[0][i];
        }
        // 자기 자신 윗 행 제외 3가지 열에 있는 값들 중
        // 각 열의 3가지 값들중 MAX값을 받아오기
        for (int i = 1 ; i< N; i++){
            for (int j= 0; j < 4; j++){
                int one = (j+1) % 4;
                int two = (j+2) % 4;
                int thr = (j+3) % 4;
                dp[i][j] = land[i][j] + Math.max(dp[i-1][one],Math.max(dp[i-1][thr],dp[i-1][two]));
            }
        }
        int max = 0;
        for (int i = 0; i<4;i++){
            max = Math.max(max,dp[N-1][i]);
        }
        return max;
    }
}