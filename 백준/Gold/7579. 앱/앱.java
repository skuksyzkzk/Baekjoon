
import java.util.*;
import java.io.*;

class Main {
	
	// i번쨰 앱까지 활용했을때 j 비용을 들여서 확보할수있는 MAX메모리 
	static int[][] dp ;// i는 해당 아이템 번호 , j 는 비용의 합 
	// 어처피 큰 메모리 가져가면 그건 아래꺼 다 가능하다.
	static int[] mem;
	static int[] cost;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// N과 M이 주어지는데 M이상을 확보하는 최소비요을 구해라 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		mem = new int[N+1];
		cost = new int[N+1];
		
		dp = new int[N+1][10_001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1 ; i <= N ;i++ ) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1 ; i <= N ;i++ ) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i<=N;i++) {
			for (int j = 0 ; j <= 10000; j++) {
				// 현재 cost로 app을 비활성화 할 수없다. => 위에꺼 그대로 
				// 이전 행의 값 
				if (cost[i] > j) dp[i][j] = dp[i-1][j];
				// 현재 cost로 app 비 활성화 가능 
				// 현재 비활성해서 얻은 num + 남은 cost만큼 사용해서 얻은 mem vs 이전행 값의 MAX값 
				else {
					if (j - cost[i] >= 0) dp[i][j] = Math.max(dp[i-1][j], mem[i] + dp[i-1][j-cost[i]]);
					else dp[i][j] = Math.max(dp[i-1][j], mem[i]);
					
				}		
			}
		}
	
		// 마지막 탐색시에 tartget 메모리값과 같거나 넘는 인덱스가 비용이다.
		for (int i = 0; i <= 10_000; i++) {
			if (dp[N][i] >= M) {
				System.out.println(i);
				return;
			}
		}
	
		
	}
}