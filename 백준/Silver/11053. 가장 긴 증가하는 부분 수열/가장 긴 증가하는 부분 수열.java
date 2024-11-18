import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lis = new int [N];
		int[] arr = new int [N];
		for (int i = 0; i < N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// LIS는 각 해당 위치의 LIS 길이 저장
		// 조건 : 해당 위치보다 낮지만 해당 숫자보다 작은 LIS중 가장 큰값이랑 + 1 
		// 만약 같은 값이면 그 값으로
		lis[0] = 1;
		for (int i = 1; i < N;i++) {
			int maxValue = 0 ;
			for (int j = i-1 ; j >=0;j--) {
				if (arr[j] > arr[i])continue;
				else if (arr[j] < arr[i] && maxValue < lis[j]) {
					maxValue = lis[j];
				}
			}
			lis[i] = maxValue + 1;
		}
		int maxNum = 0 ;
		maxNum = Arrays.stream(lis).max().getAsInt();
		System.out.println(maxNum);
		
	}

}