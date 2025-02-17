import java.util.*;

import javax.management.openmbean.ArrayType;

import java.io.*;

class Main {
	static int[] numbers;
	static int[] lis;
	static int[] trace;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		lis = new int[N];
		trace = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N ; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		lis[0] = numbers[0];
		int idx = 0;
		// 비교해서 자리 찾기 
		for (int i = 1 ; i < N; i++) {
			if (numbers[i] > lis[idx]) {
				lis[++idx] = numbers[i];
				trace[i] = idx;
			} else {
				int target = lowerBound(numbers[i],idx);
				lis[target] = numbers[i];
				trace[i] = target;
			}
		}
		int length = idx+1;
		StringBuilder sb = new StringBuilder();
		sb.append(length+"\n");
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = N-1; i >= 0 ; i--) {
			if(trace[i] == idx) {
				stack.push(numbers[i]);
				idx--;
			}	
		}
		for (int next : stack) {
			sb.append(next+" ");
		}
		System.out.println(sb);
	}
	// lowerBound를 리턴한다.
	private static int lowerBound(int find,int idx) {
		int left = 0 ;
		int right = idx+1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (lis[mid] >= find) right = mid;
			else left = mid + 1;
		}
		
		return right;
	}
}