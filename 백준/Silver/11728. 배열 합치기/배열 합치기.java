import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] nArr = new int[N];
		for (int i = 0 ; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] mArr = new int[M];
		for (int i = 0 ; i < M; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0; int right = 0;
		while (left < N || right < M) {
			if (left == N) {
				sb.append(mArr[right++]+" ");
				continue;
			}
			if (right == M) {
				sb.append(nArr[left++]+" ");
				continue;
			}
			if (nArr[left] <= mArr[right]) {
				sb.append(nArr[left++]+" ");
			}
			else if (nArr[left] > mArr[right]){ 
				sb.append(mArr[right++]+" ");
			}
				
		}
		System.out.println(sb.toString());
	}
}