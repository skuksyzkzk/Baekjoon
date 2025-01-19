import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> original = new HashMap<>();
        for (int i= 0 ; i < want.length; i ++){
            original.put(want[i],number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++){
            HashMap<String,Integer> map = new HashMap<>(original);
            boolean flag = true;
            for (int j = i; j < i + 10; j++){
                if (!map.containsKey(discount[j]) || map.get(discount[j]) == 0 ) {
                    flag = false;
                    break;
                }
                if (map.get(discount[j]) > 0 ){
                    map.put(discount[j],map.get(discount[j]) - 1);
                }
            }
            if (flag) answer++;
           
        }
        return answer;
    }
}