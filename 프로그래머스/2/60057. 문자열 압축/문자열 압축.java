class Solution {
    public int solution(String s) {
        // 만약 문자열 길이가 1이면, 어떤 방식으로도 더 줄일 수 없으므로 1 반환
        if (s.length() == 1) {
            return 1;
        }
        
        int answer = s.length();  // 초기값: 압축하지 않았을 때의 길이로 설정
        
        // 1 ~ (문자열 길이 / 2)까지 단위 길이(candidate)로 시도
        for (int step = 1; step <= s.length() / 2; step++) {
            // 압축된 결과를 담을 StringBuilder (String 사용보다 성능이 좋음)
            StringBuilder compressed = new StringBuilder();
            
            // 첫 덩어리
            String prev = s.substring(0, step);  // 앞에서 step 길이만큼 자름
            int count = 1;  // prev가 몇 번 반복 중인지 세는 카운트
            
            // step 간격으로 다음 덩어리들을 비교
            for (int idx = step; idx < s.length(); idx += step) {
                // 다음 덩어리(부분 문자열) 구하기
                // idx + step이 문자열 길이를 초과할 수 있으므로, endIndex는 s.length()와 비교
                int endIndex = Math.min(idx + step, s.length());
                String current = s.substring(idx, endIndex);
                
                // 이전 덩어리(prev)와 같다면 count 증가
                if (prev.equals(current)) {
                    count++;
                } else {
                    // 다르면, 지금까지 쌓인 prev 정보를 압축 결과에 반영
                    if (count > 1) {
                        compressed.append(count).append(prev);
                    } else {
                        compressed.append(prev);
                    }
                    // 현재 덩어리를 새로 세팅
                    prev = current;
                    count = 1;
                }
            }
            // for문이 끝났으면, 마지막으로 쌓인 prev 처리
            if (count > 1) {
                compressed.append(count).append(prev);
            } else {
                compressed.append(prev);
            }
            
            // 현재 step으로 압축된 문자열 길이
            int compressedLength = compressed.length();
            // 최소값 갱신
            answer = Math.min(answer, compressedLength);
        }
        
        return answer;
    }
}
