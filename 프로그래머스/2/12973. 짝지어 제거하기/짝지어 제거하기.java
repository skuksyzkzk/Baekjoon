import java.util.*;

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i =0;i<s.length();i++){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else {
                if (stack.peek() != s.charAt(i)) stack.push(s.charAt(i));
                else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}