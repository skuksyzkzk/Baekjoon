import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int num : numbers){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (a,b) -> {
            int A = Integer.parseInt(a+b);
            int B = Integer.parseInt(b+a);
            return Integer.compare(B,A);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String str : list){
            sb.append(str);
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}