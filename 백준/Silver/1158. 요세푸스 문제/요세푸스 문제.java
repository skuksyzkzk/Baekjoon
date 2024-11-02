


import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= n; i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int idx = 0;
        while(list.size() > 1) {
            idx = (idx + (k - 1)) % list.size();
            sb.append(list.remove(idx) + ", ");
        }
        sb.append(list.get(0)+">");

        System.out.println(sb.toString());

    }

}