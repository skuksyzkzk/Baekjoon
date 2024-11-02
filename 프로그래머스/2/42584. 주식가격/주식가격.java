import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        // 남는 시간 배열 선언 및 초기화
        int[] answer = new int[N];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < N; i++){
            // 스택이 not empty, 이전 Top이 클 경우
            while ( !stack.isEmpty() && prices[stack.peek()] > prices[i] ){
                int targetIdx = stack.pop();
                answer[targetIdx] = i - targetIdx;   
            }
            stack.push(i);
        }
        
        // 최종 스택에서 남은 시간 확정 
        for (int i : stack){
            answer[i] = N - 1 - i;
        }
        
        return answer;
        
    }
}