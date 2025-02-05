import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Integer.parseInt(st.nextToken());
		long Y = Integer.parseInt(st.nextToken());
		
		int Z = (int) (Y*100 /X);
		
		if (Z >= 99) {
			System.out.println(-1);
		}else {
			int alpha = (int)Math.ceil((100 * Y - X*Z - X) / (double)(Z - 99)); 
			System.out.println(alpha);
		}
	}
}