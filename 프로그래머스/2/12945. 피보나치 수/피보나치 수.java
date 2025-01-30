import java.util.*;

class Solution {
    static int[] F;
    public int solution(int n) {
        int answer = 0;
        F = new int[n+1];
        F[0] = 0; F[1] = 1;
        fibo(n);

        return F[n];
    }
    static int fibo(int n) {
        if (n ==0|| F[n] > 0) {
            return F[n];
        }
        return F[n] = (fibo(n-1) + fibo(n-2) )% 1234567;
    }
}