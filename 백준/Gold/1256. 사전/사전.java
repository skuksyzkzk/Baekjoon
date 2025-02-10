import java.util.*;
import java.io.*;

class Main {
	static long[][] pascal;
	static int MAX = 1_000_000_001;
	static void makePascal() {
		pascal[0][0] = 1L;
		pascal[1][0] = 1L; pascal[1][1] = 1L;
		long target = 0;
		for (int i = 2; i < pascal.length; i++) {
			pascal[i][0] = 1; pascal[i][i] = 1;
			for (int j = 1; j < i; j++) {
				pascal[i][j] = Math.min(pascal[i-1][j]+pascal[i-1][j-1],MAX);
			}
        }
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		pascal = new long[N+M+1][N+M+1];
		int K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		makePascal();
        
		if (K > pascal[N+M][N]) {
			System.out.println(-1);
			return;
		}
		while (K!=1) {
			
			// a 박았을 때 K가 나오는 조합보다 미만이면 Z박고 K갱신
			long order = pascal[N+M-1][M];
			
			if (order < K) {
				sb.append("z");
				K -= order;
				M--;
			}
			else {
				sb.append("a");
				N--;
			}
			
		}
		while (N > 0) {
			sb.append("a");
			N--;
		}
		while (M > 0) {
			sb.append("z");
			M--;
		}
		
		System.out.println(sb.toString());
	}
}