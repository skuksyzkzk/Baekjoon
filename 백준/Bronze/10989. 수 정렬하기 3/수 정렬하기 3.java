import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[10001];
		for (int i = 0; i< N;i++) {
			int v = Integer.parseInt(br.readLine());
			arr[v]+=1;
		}
		for (int i = 1; i<= 10000;i++) {
			if (arr[i] > 0) {
				for (int j = 0; j<arr[i];j++) {
					sb.append(i+"\n");
				}
			}
		}
		System.out.println(sb);
	}
}