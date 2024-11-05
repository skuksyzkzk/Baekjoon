import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 이름 -> 신고당한 횟수 
        HashMap<String,Integer> nameToCount = new HashMap<>();
        // 이름 -> 신고한 사람
        // 이렇게 해야지 동일한 유저 신고시 1번 처리 
        HashMap<String, List<String>> nameToReporters = new HashMap<>();
        
        for (int i = 0; i< report.length;i++){
            String[] s = report[i].split(" ");
            
            // Null Pointer 방지 
            if (!nameToReporters.containsKey(s[1])){
                nameToReporters.put(s[1],new ArrayList<>());
            }
            // 신고횟수 추가 -> 이때 이미 신고한 사람인지 확인 
            if (!nameToReporters.get(s[1]).contains(s[0])){
                nameToCount.put(s[1],nameToCount.getOrDefault(s[1],0) + 1);
                nameToReporters.get(s[1]).add(s[0]);
            }
            
        }
        // 정지되는 사람 
        List<String> stopper = nameToCount.entrySet().stream().
            filter(entry -> entry.getValue() >= k).map(Map.Entry::getKey)
            .collect(Collectors.toList());
        // 정지되는 사람들을 신고한 사람들의 카운트 저장 
        HashMap<String,Integer> last = new HashMap<>();
        
        for (String s : stopper) {
            for (String name : nameToReporters.get(s)){
                last.put(name,last.getOrDefault(name,0)+1);
            }
        }
        
        int[] answer = new int [id_list.length];
        for ( int i = 0 ; i < id_list.length;i++){
            if (last.containsKey(id_list[i])) answer[i] = last.get(id_list[i]);
            else answer[i] = 0;
        }
        return answer;
    }
}