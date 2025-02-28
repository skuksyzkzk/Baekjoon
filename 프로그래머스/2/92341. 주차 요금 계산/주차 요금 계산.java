import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int maxTime = 23 * 60 + 59;
        int basicTime = fees[0]; int basicPrice = fees[1];
        int unitTime = fees[2]; int unitPrice = fees[3];
        // 차번호 : 분 
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        TreeSet<String> carNumber = new TreeSet<>();
        // 입력 받은 것에서 있으면 넣고 없으면 만들기 
        HashMap<Integer,Integer> carMap = new HashMap<>();
        for (String str : records){
            String[] inputs = str.split(" ");
            String[] times = inputs[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            String car = inputs[1];
            carNumber.add(car);
            map.putIfAbsent(car, new ArrayList<>());
            
            map.get(car).add(time);
        }
        int[] answer = new int[carNumber.size()];
        int idx = 0;
        for (String num : carNumber) {
            int i = 1; int total = 0;
            int past = 0;
            for (int t : map.get(num)){
                if (i % 2 == 0){
                    total += t - past;
                } else {
                    past = t;
                }
                i++;
            }
            if (i % 2 == 0){
                total += maxTime - past;    
            }
            if (total < basicTime) {
                answer[idx++] = basicPrice;
            } else{
                answer[idx++] = basicPrice +(( int) Math.ceil((double) (total - basicTime) / unitTime) * unitPrice); 
            }
        }
        
        
        return answer;
    }
}