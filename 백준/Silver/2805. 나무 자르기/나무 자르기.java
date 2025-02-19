import java.util.*;
import java.io.*;

class Main {
	static int N,M;
	static int[] branches;

	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		branches = new int[N];
		int maxLen = 0;
		int maxIdx = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < N ;i ++) {
			int len = Integer.parseInt(st.nextToken());
			branches[i] = len;
			if (maxLen < len) {
				maxLen = len;
				maxIdx = i;
			}
		}
		// 이분 탐색 시작
		System.out.println(binarySearch(maxLen,maxIdx));
	}
	
	private static int binarySearch(int maxLen, int maxIdx) {
		int left = 0; int right = maxLen;
		
		while (left < right) {
			long sum = 0;
			int mid = (left + right + 1) / 2;
			//System.out.println(left +" "+right +" "+ mid);
			for (int i = 0 ; i < N; i++) {
				if (branches[i] > mid) {
					sum += (branches[i] - mid); 
				}
			}
			if (sum == M) return mid;
			else if (sum > M) left = mid;
			else if (sum < M) right = mid-1;
		}
		return left;
	}
}