import java.util.*;
import java.io.*;

class Main {
	static int N,M;
	static int[] S;
	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		S = new int[N+1]; // 해당 위치까지의 부분합
		S[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i<=N;i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		int left = 0; int right = 1;
		int answer = 0;
		while (left <= right && right <= N) {
			int diff = S[right] - S[left];
			if (diff == M) {
				right++;
				answer++;
			}else if (diff > M) {
				left++;
			}else if (diff < M) {
				right++;
			}
		}
		System.out.println(answer);
	}
}