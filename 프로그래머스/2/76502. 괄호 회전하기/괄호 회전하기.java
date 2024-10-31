import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        // 짝 맞추는 용도 
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        ArrayDeque<Character> save = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            save.addLast(c);
        }
    
        for (int i =0; i<s.length();i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            boolean isVaild = true;
            for (char target : save  ){
                if (!map.containsKey(target)) stack.push(target);
                else {
                    if (stack.isEmpty()){
                        isVaild = false;
                        break;
                    }else if (!map.get(target).equals(stack.pop())){
                        isVaild = false;
                        break;
                    }
                }
               
            }
            if (isVaild && stack.isEmpty()) answer++;
            char temp = save.pollFirst();
            save.addLast(temp);
        }
        
        return answer;
    }
}