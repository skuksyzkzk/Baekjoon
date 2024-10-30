import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 중복제거 이건 따로 빼면 됨 distinct() o(n)
        Set<Integer> s = new HashSet<>();
        for (int i = 0;i<numbers.length;i++){
            for (int j = i+1; j<numbers.length;j++){
                s.add(numbers[i]+numbers[j]);
            }
        }
       
        return s.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}