import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		// 큐에 처음 초기화 1 2 3 4 ~ 
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		int idx = 0;
		while (list.size() > 1) {
			idx = (idx + K - 1) % list.size();
			sb.append(list.remove(idx)+", ");
		}
		sb.append(list.get(0)+">");
		
		System.out.println(sb.toString());
		
	}
} 