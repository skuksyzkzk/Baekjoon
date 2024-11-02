import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        int strSize = s.length();
        for (int startIdx = 0; startIdx < strSize;startIdx++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean flag  = true;
            for (int i = startIdx; i < startIdx + strSize; i++ ){
                int accessIdx = i % strSize;
                char target = s.charAt(accessIdx);
                if (!map.containsKey(target)) stack.push(target);
                else {
                    if (stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    else if (!map.get(target).equals(stack.pop())){
                        flag = false;
                        break;
                    }
                }
                
            }
            if (flag && stack.isEmpty()) answer++;
        }
        return answer;
    }
}