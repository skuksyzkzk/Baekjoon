import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < completion.length; i++){
            String find = completion[i];
            map.put(find, map.getOrDefault(find,0) + 1);
        }
        for (int i = 0 ; i <participant.length; i++){
            String find = participant[i];
            if (!map.containsKey(find)) return find;
            if ( map.containsKey(find) &&  map.get(find) > 0){
                map.put(find,map.get(find) - 1);
            }else if (map.containsKey(find) && map.get(find) == 0){
                return find;
            } 
        }
        return answer;
    }
}