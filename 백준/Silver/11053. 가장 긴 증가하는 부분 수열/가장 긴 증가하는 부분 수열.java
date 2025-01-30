import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] num = new int[N];
		int[] dp = new int[N];
		for (int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int k = 0 ; k < N;  k++) {
			dp[k] = 1 ;
			for (int i = 0 ; i < k; i++) {
				if (num[i] < num[k]) {
					dp[k] = Math.max(dp[k],dp[i]+1);
				}
			}
		}
        int maxValue = 0 ; 
		for (int i = 0; i < N ; i++){
            if (maxValue < dp[i]) maxValue = dp[i];
        }
        System.out.println(maxValue);
	}
}