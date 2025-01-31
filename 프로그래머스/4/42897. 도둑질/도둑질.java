import java.util.*;

class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length+1];
        int[] dp2 = new int[money.length+1];
        // 첫번째 집을 들릴 경우 -> 마지막 집 무조건 안들린다.
        dp1[1] = money[0]; dp1[2] = money[0]; dp1[3] = dp1[1] + money[2];
        for (int i = 4; i < money.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i-1]);
        }
        // 첫번째 집을 들리지 않을 경우
        dp2[1] = 0; dp2[2] = money[1]; dp2[3] = Math.max(money[1],money[2]);
        for (int i = 4; i <= money.length; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + money[i-1]);
        }
        
       
        
        int maxValue = Arrays.stream(dp1).max().getAsInt();
        if (maxValue < Arrays.stream(dp2).max().getAsInt()) 
            maxValue = Arrays.stream(dp2).max().getAsInt();
        return maxValue;
    }
}