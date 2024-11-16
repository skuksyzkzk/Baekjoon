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
		
		int total = given.length();
		given = given.replace(target,"");
		System.out.println((total - given.length()) / target.length());
	}
}
