import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 문자열 저장 Deque
        ArrayDeque<Character> list = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            list.addLast(c);
        }
        
        // 짝 맞춰놓기 
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        int strSize = s.length();
        for (int i = 0;i < strSize;i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isVaild = true;
            for (char target : list){
                if (!map.containsKey(target)) stack.push(target);
                else {
                    if (stack.isEmpty()){
                        isVaild = false;
                        break;
                    }
                    else if (!map.get(target).equals(stack.pop())){
                        isVaild =false ;
                        break;
                    }
                
                }
                
            }
            if (isVaild && stack.isEmpty()) answer++;
                
            char temp = list.poll();
            list.addLast(temp);
        }
        
        
        return answer;
    }
}