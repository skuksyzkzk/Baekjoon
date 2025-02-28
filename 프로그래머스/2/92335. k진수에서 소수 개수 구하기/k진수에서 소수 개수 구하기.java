import java.util.*;

class Solution {
    
    public boolean isPrime(long target){
        if (target < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(target); i++){
            if (target % i == 0) return false;
        }
        
        return true;
    }
    public int solution(int n, int k) {
        
        String str = "";
        int number = n;
        int answer = 0;
        while (number > 0){
            int prefix = number % k;
            number /= k;
            str = prefix + str;
        }
        String cur = "";
        for (int i = 0 ; i < str.length(); i++){
            if (str.charAt(i) == '0'){
                if (cur.isEmpty()) continue;
                
                long parse = Long.parseLong(cur);
                //System.out.println(parse);
                if (isPrime(parse)) answer++;
                
                cur = "";
            } else{
                cur += str.charAt(i);
            }
        }
        if (!cur.isEmpty() && isPrime(Long.parseLong(cur))) {
            answer++;
        }
        return answer;
    }
}