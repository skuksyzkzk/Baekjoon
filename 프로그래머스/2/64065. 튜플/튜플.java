import java.util.*;

class Solution {
    public int[] solution(String s) {
        String input = s.substring(0,s.length()-2).replace("{","");
        String[] save = input.split("},");
        
        Arrays.sort(save,(a,b) -> Integer.compare(a.length(),b.length()));
        int[] answer = new int[save.length];
        HashSet<String> set = new HashSet<>();
        int idx = 0;
        for (String str : save){
            String[] temp = str.split(",");
            for (String a : temp) {
                if(!set.contains(a)){
                    answer[idx++] = Integer.parseInt(a);
                    set.add(a);
                }
            }
        }
        
        return answer;
    }
}