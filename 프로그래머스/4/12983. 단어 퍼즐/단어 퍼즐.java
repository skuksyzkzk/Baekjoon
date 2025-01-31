import java.util.*;

class Solution {
    static int INF = 20_001; // 문자열의 최대길이가 20000 이기에
    public int solution(String[] strs, String t) {
        // 조각 문자를 Set에 넣기
        HashSet<String> set = new HashSet<>(Arrays.asList(strs));
        // 조각 문자열 사이즈 넣기 
        HashSet<Integer> sizes = new HashSet<>();
        for (int i = 0 ; i < strs.length; i++){
            sizes.add(strs[i].length());
        }
        // 최소조각수 저장 DP 배열 선언 
        int[] dp = new int[t.length()+1];
        Arrays.fill(dp,INF);
        dp[0] = 0;
        for (int len = 1; len <= t.length(); len++){
            // 조각 문자의 길이만 고려
            for (int size : sizes){
                if (len-size >= 0) {
                    String piece = t.substring( len - size , len );
                    if (set.contains(piece)) dp[len] = Math.min(dp[len],dp[len - size] + 1);
                }
            }
        }
        return dp[t.length()] == INF ? -1 : dp[t.length()];
    }
}