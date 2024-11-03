import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        int j  = 0 ;
        for (String s : want) {
            map.put(s,number[j]);
            j++;
        }
       
        for (int i = 0 ; i < discount.length - 9; i++){
            HashMap<String,Integer> cur = new HashMap<>(map);
           
            for ( int st = i; st < i + 10; st++){
                if (cur.getOrDefault(discount[st],0) == 0) continue;
                cur.put(discount[st], cur.get(discount[st]) - 1);
            }
           
            if (cur.values().stream().allMatch(value -> value == 0)){
                answer++;
            }
        }
        return answer;
    }
}