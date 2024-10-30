import java.util.*;

public class Solution {

    public int[] solution(int N, int[] stages) {
        // ❶ 스테이지별 도전자 수를 구함
        int[] challenger = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        // ❷ 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // ❸ 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) { // ❹ 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.);
            }
            else {
                fails.put(i, challenger[i] / total); // ❺ 실패율 구함
                total -= challenger[i]; // ❻ 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }
        
        ArrayList<Map.Entry<Integer, Double>> arr = new ArrayList<>(fails.entrySet());
        
        Collections.sort(arr, (a,b) -> {
            if(a.getValue() == b.getValue()){
                return Double.compare(a.getKey(), b.getKey());    
            }
            else{
                return Double.compare(b.getValue(), a.getValue());    
            }
        });
         
        int[] arr2 = new int[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            arr2[i] = arr.get(i).getKey();
        }
        // ❼ 실패율이 높은 스테이지부터 내림차순으로 정렬
        return arr2;
    }

}