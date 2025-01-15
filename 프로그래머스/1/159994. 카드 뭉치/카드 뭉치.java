import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {

        ArrayDeque<String> c1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> c2 = new ArrayDeque<>(Arrays.asList(cards2));
        int i = 0;
        for ( ; i < goal.length; i ++) {
            String target = goal[i];
            // c1이 비어있지 않고 c1의 앞의 값이 일치할 경우
            if (!c1.isEmpty() && target.equals(c1.peekFirst())) {
                c1.pollFirst();
            }
            // c2이 비어있지 않고 c2의 앞의 값이 일치할 경우
            else if (!c2.isEmpty() && target.equals(c2.peekFirst())) {
                c2.pollFirst();
            }
            /*
                1. c1과 c2가 비어있는 경우 
                2. target 값과 일치하는 게 없는 경우 
            */
            else {
                return "No";
            }
        }
        // 둘다 사용되고 goal이 전부 소진 되어 있는 경우
        
        return "Yes";
    }
}