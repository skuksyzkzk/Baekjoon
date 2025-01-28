import java.util.*;

class Solution {
    public int[] solution(String s) {
        String temp = s.substring(0,s.length()-2).replace("{","");
        String[] inputs = temp.split("},");
        
        Arrays.sort(inputs, (a,b) -> Integer.compare(a.length(),b.length()));
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[inputs.length];
        
        int i = 0;
        for (String str : inputs){
            String[] numbers = str.split(",");
            for (String num : numbers){
                if(!set.contains(num)){
                    answer[i++] = Integer.parseInt(num);
                    set.add(num);
                }
            }
        }
        return answer;
    }
}