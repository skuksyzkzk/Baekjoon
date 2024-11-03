import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] dayLeft = new int[progresses.length];
        // 날짜를 계산 하기 
        for (int idx = 0; idx < progresses.length; idx ++) {
            if ((100 - progresses[idx]) % speeds[idx] == 0)  
                dayLeft[idx] = (100 - progresses[idx]) / speeds[idx];
            else 
                dayLeft[idx] = (100 - progresses[idx]) / speeds[idx] + 1;
        }
        
        int maxDay = dayLeft[0];
        int count = 0;
        
        for (int i = 0 ; i < dayLeft.length;i++){
            if (dayLeft[i] <= maxDay) {
                count++;
            }
            else {
                maxDay  = dayLeft[i];
                answer.add(count);
                count = 1;
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}