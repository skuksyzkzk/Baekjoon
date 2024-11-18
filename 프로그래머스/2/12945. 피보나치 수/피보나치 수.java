import java.util.*;
import java.io.*;

class Solution {
    private static int[] dp;
    public int solution(int n) {
        int answer = 0;
        dp = new int [n+1];
        answer = fibo(n);
        return answer;
    }
    private static int fibo(int n){
        if (dp[n] != 0) return dp[n];
        if (n <= 2) return dp[n] = 1;
        else return dp[n] = ( fibo(n-1) + fibo(n-2) ) % 1234567;
    }
}