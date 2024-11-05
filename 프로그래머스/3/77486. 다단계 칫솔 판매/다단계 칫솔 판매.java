import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String,String> parents = new HashMap<>();
        parents.put("-","end");
        // 부모 정보 저장
        for (int i = 0; i< enroll.length;i++){
            parents.put(enroll[i],referral[i]);
        }
        
        // 이름과 돈 저장
        HashMap<String,Integer> moneys = new HashMap<>();
        for (String s : enroll){
            moneys.put(s,0);
        }
        moneys.put("-",0);
        for ( int i = 0 ; i < seller.length;i++){
            String s  = seller[i];
            int total = amount[i] * 100;
    
            while(!"end".equals(parents.get(s))){
                int yours = total / 10;
                int mine = total - yours;
                if (yours < 1) {
                    mine = total;
                }
                moneys.put(s,moneys.get(s) + mine);
                if (yours < 1){
                    break;
                }
                s = parents.get(s);
                total = yours;
            }
        }
        
        int[] answer = new int[enroll.length];
        int idx=  0;
        for (String s : enroll){
            answer[idx] = moneys.get(s);
            idx++;
        }
        
        return answer;
    }
}