
import java.util.*;
import java.io.*;

class Main {
	static class Item {
		int weight,value;
		public Item (int w,int v) {
			this.weight= w;
			this.value = v;
		}
	}
	static int[][] dp; // i번째 물건을 사용해서 무게 j까지 채웠을떄 가치의 맥스 
	static int N ,K;
	static Item[] items;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1];
		items = new Item[N+1];
		
		for (int i = 1 ; i <=N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			items[i] = new Item(weight,value);
		}
		
		for (int i =1 ; i<= N; i++) {
			for (int j = 0 ; j <= K ; j++ ) {
				// 현재 아이템을 못담는 다면 전부 이전값 내려온다.
				if (items[i].weight > j) dp[i][j] = dp[i-1][j];
				// 현재 아이템을 담을 수 있으면 이전 행의 값 vs 현재 아이템을 담고 남는 무게 만큼 담을수 있는 이전행의값 
				else {
					dp[i][j] = Math.max(dp[i-1][j], items[i].value + dp[i-1][j-items[i].weight]);
				}
			}
		}
		System.out.println(dp[N][K]);

	}
}