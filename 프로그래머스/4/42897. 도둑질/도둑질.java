import java.util.*;

class Solution {
    public int solution(int[] money) {
        int N = money.length;
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        
        // 첫번째 집 선탟 3번째까지 정해짐 
        dp1[0] = money[0]; dp1[1] = money[0]; dp1[2] = money[0] + money[2];
        // 첫번째 집 선택 안하는 경우는 2번째까지만 정해짐 
        dp2[0] = 0 ; dp2[1] = money[1];
        // 첫번째 집을 선택한 경우, 마지막 집 선택불가 
        // i-2번째 까지 합과 i-3번째 까지 합중 비교해서 MAX값을 현재값에 더해야된다.
        for (int i = 3 ;i <N-1;i++){
            dp1[i] = money[i] + Math.max(dp1[i-2],dp1[i-3]);
        }
        // 첫번째 집을 선택하지 않는 경우는 선택을 해야한다.
        // i-1 값과 i-2 + 현재값을 비교해서 큰값을 선택한다.
        for (int i = 2; i< N;i++){
            dp2[i] = Math.max(dp2[i-1],money[i] + dp2[i-2]);
        }
        // 최종적으로 dp1[N-2] 값과 dp2[N-1]값 비교
        int answer = 0;
        for (int i = 0; i<N;i++){
            answer= Math.max(answer,dp1[i]);
        }
        for (int i = 0; i<N;i++){
            answer= Math.max(answer,dp2[i]);
        }
        
        return answer;
    }
}