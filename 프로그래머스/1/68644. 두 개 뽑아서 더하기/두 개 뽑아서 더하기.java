import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set  = new HashSet<>();
        for ( int i = 0 ; i < numbers.length; i++ ) {
            for ( int j = i+1 ; j < numbers.length; j++ ){
                set.add(numbers[i] + numbers[j]);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>(set);
        Collections.sort(arr);
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}