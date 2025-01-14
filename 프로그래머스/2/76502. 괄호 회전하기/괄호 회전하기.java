import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
    
        char[] inputs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n;i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean flag = false;
            for (int j = i ; j < i + n;j++){
                if (inputs[j % n ] == '[' || inputs[j % n] == '{' || inputs[j % n] == '('){
                    stack.offerLast(inputs[j%n]);
                }
                else if (stack.isEmpty() || stack.pollLast() != map.get(inputs[j%n]) ){
                    flag = true;
                    break;
                }
            }
            if(!flag && stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}