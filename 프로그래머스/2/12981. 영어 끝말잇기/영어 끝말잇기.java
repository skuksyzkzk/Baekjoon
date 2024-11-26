import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // 가장 먼저 탈락하는 사람의 번호와 그 사람 기준이 몇번째인지 
        HashSet<String> set = new HashSet<>();
        int[] count = new int[n];
        String start = String.valueOf(words[0].charAt(0));
        for (int i = 0; i<words.length;i++){
            int who = i % n;
            count[who]++;
            if (!words[i].startsWith(start)){
                return new int[] {who+1,count[who]};
            }
            if (set.contains(words[i])){
                return new int[] {who+1,count[who]};
            }else {
                set.add(words[i]);
            }
            start = String.valueOf(words[i].charAt(words[i].length()-1));
        }
        return new int[] {0,0};
       
    }
}