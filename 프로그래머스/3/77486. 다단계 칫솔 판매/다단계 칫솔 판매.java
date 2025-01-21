import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        // 이름과 인덱스 정보
        HashMap<String,Integer> person = new HashMap<>();
        for (int i = 0 ; i < enroll.length; i++){
            person.put(enroll[i],i);
        }
        // 자식과 부모관계 
        HashMap<String,String> relation = new HashMap<>();
        for (int i = 0 ; i < referral.length;i++){
            if ("-".equals(referral[i])) relation.put(enroll[i],"center");
            else relation.put(enroll[i],referral[i]);
        }
        // 이익금 계산 
        for (int i = 0 ; i < seller.length; i++){
            int total = amount[i] * 100;
            String target = seller[i];
            while (!"center".equals(relation.get(target))){
                if (total == 0 ) break;
                int index = person.get(target);
                answer[index] += total - total/10;
                total /=10;
                target = relation.get(target);
            }
            if (total != 0){
                int index = person.get(target);
                answer[index] += total -  total/10;
            }
        }
        
        
        return answer;
    }
}