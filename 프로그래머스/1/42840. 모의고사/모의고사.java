import java.util.*;

class Solution {
    static int[] first = {1,2,3,4,5};
    static int[] second =  {2,1,2,3,2,4,2,5};
    static int[] third = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] count = new int[3];
        for (int i = 0 ; i < answers.length; i++){
            if (first[i%5] == answers[i]) count[0]++;
            if (second[i%8] == answers[i]) count[1]++;
            if (third[i%10] == answers[i]) count[2]++;
        }
        int maxValue = Arrays.stream(count).max().getAsInt();
        for (int i = 0 ; i< 3; i ++){
            if (count[i] == maxValue){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}