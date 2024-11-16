import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String given = br.readLine();
		String target = br.readLine();
		
		int lastIdx = -1;
		int dif = target.length();
		int offset = dif - 1;
		int count = 0;
		for (int i = 0; i<= given.length() - dif; i++) {
			if(target.equals(given.substring(i,i+dif)) && lastIdx < i) {
				lastIdx = i + offset;
				count++;
			}
		}
		System.out.println(count);
	}
}
