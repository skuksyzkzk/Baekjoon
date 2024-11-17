import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N ; i++) {
			int value = Integer.parseInt(br.readLine());
			arr[i] = value;
		}
		Arrays.sort(arr);
		ArrayList<Integer> two = new ArrayList<>();
		// two 배열 만들기
		for (int i = 0; i < N; i ++) {
			for (int j = i; j < N; j++) {
				two.add(arr[i]+arr[j]);
			}
		}
		int[] two_arr = two.stream().mapToInt(Integer::intValue).toArray();
		Arrays.sort(two_arr);
		// k를 찾기 
		for (int k = N-1; k >= 0; k--) {
			for (int l = 0;l < k ; l++) {
				if (binarySearch(two_arr,arr[k]-arr[l])) {
					System.out.println(arr[k]);
					return ;
				}
			}
		}
	}
	private static boolean binarySearch(int[] arr,int find) {
		int lt = 0; int rt = arr.length-1;
		while(lt <= rt) {
			int mid = (lt+rt) / 2;
			if (arr[mid] == find) return true;
			else if (arr[mid] > find) rt = mid -1;
			else lt = mid +1;
		}
		return false;
	}
}