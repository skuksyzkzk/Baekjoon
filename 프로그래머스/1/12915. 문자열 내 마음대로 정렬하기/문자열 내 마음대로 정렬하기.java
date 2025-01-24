import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0;  i < strings.length;i++){
            arr.add(strings[i]);
        }
        
        Collections.sort(arr,(a,b) -> {
            if (a.charAt(n) == b.charAt(n)) return a.compareTo(b);
            return Character.compare(a.charAt(n),b.charAt(n));
        });
        return arr.stream().toArray(String[]::new);
    }
}