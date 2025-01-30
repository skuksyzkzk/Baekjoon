import java.util.*;
import java.io.*;

class Main {
	static int[] num;
	static int[] dp;
	static int[] rec;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		num = new int[N];
		dp = new int[N];
		rec = new int[N];
		
 		for (int i = 0 ; i < N ; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
 		int j = 0;
 		dp[j] = num[0];
 		int i = 1;
 		while (i < N) {
 			// 현재 LIS의 마지막 보다 크면 순열에 추가 
 			if (dp[j] < num[i]) {
 				j+=1;
 				dp[j] = num[i];
 			}
 			// 작을 경우 올바른 위치 찾아서 삽입하기 
 			else {
 				int pos = binarySearch(0,j,num[i]);
 				dp[pos] = num[i];
 			}
 			i++;
 		}
		System.out.println(j+1);
	}

	private static int binarySearch(int i, int j, int find) {
		int mid = 0;
		int lt = i, rt = j;
		while (lt < rt) {
			mid = (lt+rt)/2 ;
			if (dp[mid] < find) lt = mid+1;
			else rt = mid;
		}
		return rt ;
	}
}