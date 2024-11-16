import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        boolean java = false ;
        boolean c = false;
        
        for (int i =0; i<sb.length();i++) {
        	if (sb.charAt(i) == '_') {
        		c = true;
        	}
        	if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
        		java = true;
        	}
        }
        // java : 맨 처음에 대문자 일경우 문제
        // c : _가 처음이나 , _이 끝에 있을 경우, __이 두개 연속 반복될경우
        if (sb.charAt(0) >= 'A' && sb.charAt(0) <= 'Z') {
        	System.out.println("Error!");
        	return;
        }
        if (sb.charAt(0) == '_' || sb.charAt(sb.length()-1) == '_'
        		|| sb.indexOf("__") >0 || (java && c)) {
        	System.out.println("Error!");
        	return;
        }
        
        if (java) {
        	for (int i= 0; i< sb.length();i++) {
        		if (sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
        			sb.replace(i,i+1,String.valueOf(sb.charAt(i)).toLowerCase());
        			sb.insert(i, "_");
        		}
        	}
        } 
        if (c){
        	for (int i= 0; i< sb.length();i++) {
        		if (sb.charAt(i) == '_') {
        			sb.deleteCharAt(i);
        			sb.replace(i, i+1, String.valueOf(sb.charAt(i)).toUpperCase());
        		}
        	}
        }
        System.out.println(sb);
  
        
        
    }
}
