import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력: 첫 줄에는 N과 패턴
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split("\\*");
        String first = inputs[0];
        String second = inputs[1];
        
        for (int i = 0; i < N; i++) {
            String testString = br.readLine();
            if (testString.length() < first.length() + second.length()) {
            	sb.append("NE\n");
            	continue;
            }
            if (testString.startsWith(first) && testString.endsWith(second)) {
            	sb.append("DA\n");
            }
            else {
            	sb.append("NE\n");
            }
            
        }

        System.out.print(sb); // 결과 출력
    }
}
