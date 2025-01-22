import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int round = 1 ;
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int num = 2;
        for (int i = 1 ; i< words.length;i++){
            if (set.contains(words[i])) return new int[]{num,round};
            else {
                if(words[i].startsWith(String.valueOf(words[i-1].charAt(words[i-1].length() - 1)))){
                    set.add(words[i]);
                    num++;
                }
                else {
                    return new int[]{num,round};
                }
            }
            if (num > n) {
                round++;
                num = 1;
            }
            
        }
        

        return answer;
    }
}