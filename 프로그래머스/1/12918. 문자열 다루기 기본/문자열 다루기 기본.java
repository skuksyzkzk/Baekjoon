import java.util.*;

class Solution {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6){
            System.out.println("here");
            return false;
        }
        for (int i = 0;i<s.length();i++){
            if (s.charAt(i) > '9') {
                System.out.println("why");
                 return false;
            }
        }
        
     
        
        return true;
    }
}