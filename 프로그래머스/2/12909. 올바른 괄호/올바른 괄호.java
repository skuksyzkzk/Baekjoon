import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        for (char c : cs){
            if (c == '(') stack.push(c);
            else {
                if (stack.isEmpty() || stack.pop() == c) return false;
            }
        }

        return stack.isEmpty() ;
    }
}