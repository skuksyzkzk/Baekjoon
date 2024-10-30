import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int one = 0;int two = 0; int three = 0;
        int[] one_arr = {1,2,3,4,5};
        int[] two_arr = {2,1,2,3,2,4,2,5};
        int[] three_arr = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0; i<answers.length;i++){
            if (answers[i] == one_arr[i%5]){
                one++;
            }
            if (answers[i] == two_arr[i%8]){
                two++;
            }
            if (answers[i] == three_arr[i%10]){
                three++;
            }
        }
        int max_value = Math.max(one,Math.max(two,three));
        Set<Integer> set = new HashSet<>();
        
        if (one == max_value)
            set.add(1);
        if (two == max_value)
            set.add(2);
        if (three == max_value)
            set.add(3);
                
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}