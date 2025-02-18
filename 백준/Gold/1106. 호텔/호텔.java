import java.util.*;
import java.io.*;

class Main {
	static int[] cost;
	static int[] number;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력 받기 구해야되는 C와 N 도시 갯수
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		cost = new int[N];
		number = new int[N];
		int max = 0;
		
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			number[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, number[i]);
		}
		// DP는 해당 인덱스 (i) 명수를 늘리기위한 최소비용 
		dp = new int[C+max+1];
		// 0명을 채우는 비용은 항상 0 
		// 미리 MAX값으로 채운다 즉 접근하지 못하는 것을 선언 
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		// dp는 num부터 시작한다 . 해당 비용으로는 해당 명수만큼 늘리기기가 가능하기에 
		for (int i = 0 ; i < N; i++) {
			int curCost = cost[i];
			int curNumber = number[i];
			// 배열 끝까지 진행하며 해당 명수 - 선택 명수가 접근가능하면 기존값과 해당명수 - 선택명수의 값 + 비용 
			// 해서 MIN값을 선택한다.
			for (int j = curNumber; j < C+max+1; j++) {
				if (dp[j-curNumber] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-curNumber] + curCost);
				}
			}
		}
		// 그 후 배열은 C값부터 MAX+1까지 확인하며 최솟값으로 답을 리턴 
		int min = Integer.MAX_VALUE;
		for (int i = C; i<C+max+1; i++) {
			min = Math.min(min, dp[i]);
		}
		System.out.println(min);
	}
}