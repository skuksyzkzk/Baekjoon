import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        for (int i = 0 ; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] inputs = new int[3];
        	inputs[0] = Integer.parseInt(st.nextToken());
        	inputs[1] = Integer.parseInt(st.nextToken());
        	inputs[2] = Integer.parseInt(st.nextToken());
        	if (i == 0 ) {
        		dp[i][0] = inputs[0]; dp[i][1] = inputs[1]; dp[i][2] = inputs[2];
        	}else {
        		for (int j = 0; j < 3; j ++) {
        			dp[i][j] = Math.min(inputs[j] + dp[i-1][(j+1)%3], inputs[j]+dp[i-1][(j+2)%3]);
        		}
        	}
        }
        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
        
    }
}