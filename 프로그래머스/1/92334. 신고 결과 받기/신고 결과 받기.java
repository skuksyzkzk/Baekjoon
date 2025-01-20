import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 신고 내역 중복 제거
        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, ArrayList<String>> reporter = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        
        // 신고 처리
        for (String rep : reportList) {
            String[] inputs = rep.split(" ");
            String reporterId = inputs[0];
            String reportedId = inputs[1];
            
            // 신고한 사용자 기록
            reporter.putIfAbsent(reporterId, new ArrayList<>());
            reporter.get(reporterId).add(reportedId);
            
            // 신고당한 사용자 카운트 증가
            count.put(reportedId, count.getOrDefault(reportedId, 0) + 1);
        }
        
        // 정지된 사용자 목록 추출
        HashSet<String> bannedUsers = count.entrySet().stream()
            .filter(entry -> entry.getValue() >= k)
            .map(Map.Entry::getKey)
            .collect(Collectors.toCollection(HashSet::new));
        
        // 결과 계산
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            for (String reportedId : reporter.getOrDefault(userId, new ArrayList<>())) {
                if (bannedUsers.contains(reportedId)) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}
