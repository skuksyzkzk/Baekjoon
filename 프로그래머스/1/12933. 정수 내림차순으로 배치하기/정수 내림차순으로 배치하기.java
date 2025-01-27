import java.util.*;

class Solution {
    public long solution(long n) {
        String temp = ""+ n;
        StringBuilder sb = new StringBuilder();
        Character[] arr = new Character[temp.length()];
        for (int i = 0 ; i < temp.length(); i++){
            arr[i] = temp.charAt(i);
        }
        Arrays.sort(arr,Collections.reverseOrder());
        for (char c : arr){
            sb.append(c);
        }
        return Long.parseLong(sb.toString());
    }
}