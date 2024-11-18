import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		char[] first = br.readLine().toCharArray();
		char[] second = br.readLine().toCharArray();
		int[][] lcs = new int [first.length+1][second.length+1];
		lcs[0][0] = 0;
		for (int i = 1; i <= first.length; i++) {
			lcs[i][0] = 0;
		}
		for (int i = 1; i <= second.length; i++) {
			lcs[0][i] = 0;
		}
		// i,j 둘이 비교하면서 
		// Lcs(i,j) 위치에서 first[i]와 second[j]가 같다면 lcs(i-1,j-1) + 1
		// Lcs(i,j) 위치에서 다르다면 lcs(i-1,j) Lcs(i,j-1) 중 최댓값 
		for (int i = 1; i<= first.length;i++) {
			for (int j = 1; j <= second.length; j++) {
				if (first[i-1] == second[j-1]) lcs[i][j] = lcs[i-1][j-1] + 1;
				else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		// 이제 남은것은 최대 값만 구하면 끝 
		System.out.println(lcs[first.length][second.length]);
	}

}