import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> c1 = new ArrayDeque<>();
        ArrayDeque<String> c2 = new ArrayDeque<>();
        ArrayDeque<String> g = new ArrayDeque<>();
        
        for (String s : cards1) {
            c1.offer(s); // 순서대로 추가
        }
        for (String s : cards2) {
            c2.offer(s); // 순서대로 추가
        }
        for (String s : goal) {
            g.offer(s); // 순서대로 추가
        }
        
        
        while ( !g.isEmpty() ){
            String target = g.pollFirst();
          
            if ( !c1.isEmpty() && c1.getFirst().equals(target)){
                c1.pollFirst();
            }
            else if ( !c2.isEmpty() &&c2.getFirst().equals(target)){
                c2.pollFirst();
            }
            else {
                return "No";
            }
            
        }
        
        return "Yes";
    }
}