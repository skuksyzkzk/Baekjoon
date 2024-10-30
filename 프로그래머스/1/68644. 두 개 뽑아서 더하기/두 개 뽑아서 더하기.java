import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 중복제거 이건 따로 빼면 됨 distinct() o(n)
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i< numbers.length;i++){
            for (int j = 0; j < numbers.length;j++){
                if (i == j) continue;
                list.add(numbers[i] + numbers[j]);
            }
        }
        Collections.sort(list);
        
        
        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }
}