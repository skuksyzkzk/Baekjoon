import java.util.*;
import java.io.*;

class Main {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[1_000_001];
		for (int i = 0 ; i < 3; i++) {
			num[Integer.parseInt(st.nextToken())]++;
		}
		for (int i = 0; i < 1_000_001;i ++) {
			if (num[i] != 0)System.out.print(i+" ");
		}
	}
}