import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<N ; i++) {
        	int value = Integer.parseInt(st.nextToken());
        	map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<M ; i++) {
        	int value = Integer.parseInt(st.nextToken());
        	arr.add(value);
        }
        
        for (int next : arr) {
        	sb.append(map.getOrDefault(next, 0)).append(" ");
        }
        
        System.out.println(sb);
    }
}
