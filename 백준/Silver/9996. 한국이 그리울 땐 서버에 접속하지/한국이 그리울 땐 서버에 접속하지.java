import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String[] given = pattern.split("\\*");
		String first = given[0];
		String second = given[1];
	
		for (int i = 0 ; i< N ; i++) {
			String pb = br.readLine();
			if ( pb.length() >= first.length() + second.length() && 
					first.equals(pb.substring(0,first.length()))&&
					second.equals(pb.substring(pb.length()-second.length(),pb.length())) ) {
				sb.append("DA\n");
			}else sb.append("NE\n");
		}
		System.out.println(sb);
	}
}