import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0 ; i < progresses.length; i ++) {
            q.addLast(progresses[i]);
        }

        int days = 0;
        int idx = 0;
        int clear = 0;
        while (!q.isEmpty()){
            int cur = q.pollFirst();
            if (cur + days * speeds[idx] >= 100) {
                clear++;
                idx++;
                continue;
            }
            if (clear > 0){
                answer.add(clear);
                clear = 0;
            }
            cur += days * speeds[idx];
            while ( cur < 100){
                days++;
                cur += speeds[idx];
            }
            clear++;
            idx++;
        }
        answer.add(clear);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}