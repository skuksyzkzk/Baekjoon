

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

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1;i <= n; i++){
            q.addLast(i);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        bw.flush();
        for (int i = 0; i < n;i++){
            if (q.size() == 1) break;
            for (int j = 0; j < k-1; j++){
                int temp = q.pollFirst();
                q.addLast(temp);
            }
            bw.write(q.pollFirst() + ", ");
            bw.flush();
        }
        bw.flush();
        bw.write(q.pollFirst() +">");
        bw.flush();
    }

}