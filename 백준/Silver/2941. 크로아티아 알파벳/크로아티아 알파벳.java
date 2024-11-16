import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String given = br.readLine();
		
		// 2아니면 3으로 substring
		// switch 문에 포함되는 단어이면  i += 1, i +=2 
		// 포함 안되면 그냥 count 증가시키고 진행 
		int total = given.length();
		int count = 0;
	
		for (int i = 0; i < given.length(); i++) {
			
			if (i <= (total - 2)) {
				String s = given.substring(i,i+2);

				switch (s) {
				case "c=":
				case "c-":
				case "d-":
				case "lj":
				case "nj":
				case "s=":
				case "z=": {
					count++;
					i+=1;
			
					break;
				}
				case "dz":{
					if (i <= total -3 && "dz=".equals(given.substring(i,i+3))) {
				
						count++;
						i+=2;
						
					}else {
						count++;
					}
					break;
				}
				default: {
				
					count++;
				}
				}
				
			}
			else{
				count++;
			}
			
			
		}
		System.out.println(count);
	}
}
