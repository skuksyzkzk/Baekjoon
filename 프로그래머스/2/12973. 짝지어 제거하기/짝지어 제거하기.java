import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        // 대표적인 스택 문제 
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] inputs = s.toCharArray();
        for (int i = 0; i < inputs.length; i++){
            if ( stack.isEmpty()) stack.offerLast(inputs[i]);
            else if ( stack.peekLast() == inputs[i] ) stack.pollLast();
            else stack.offerLast(inputs[i]);
        }
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}