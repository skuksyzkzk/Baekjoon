import java.util.*;
import java.io.*;

class Main{
	static int[][] dist;
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][N+1];
		for (int i = 0;  i <=N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b] = 1;
		}
		flodyWashel();
		
		int count = 0;
		for (int i = 1 ; i <= N; i++) {
			int coCount = 0;
			for (int j = 1 ; j <= N; j++) {
				if (i == j) continue;
				if (dist[i][j] != Integer.MAX_VALUE) coCount++;
				if (dist[j][i] != Integer.MAX_VALUE) coCount++;
			}
			if (coCount == N-1) count++;
		}
		System.out.println(count);
	}
	private static void flodyWashel() {
		for (int k = 1; k <=N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=N; j++) {
					if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
					
					if (dist[i][j] > dist[i][k] + dist[k][j]) dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
	}
}