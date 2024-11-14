
import java.util.*;
import java.io.*;

public class Solution{
	private static int T;
	private static HashMap<Integer,Integer> map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<T;i++) {
			map = new HashMap<>();
			int number = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j =0 ; j< 1000;j++) {
				int value = Integer.parseInt(st.nextToken());
				map.put(value, map.getOrDefault(value,0)+1);
			}
			List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());
			entry.sort((a,b) -> {
				int ret = Integer.compare(b.getValue(), a.getValue());
				if (ret == 0) {
					return Integer.compare(b.getKey(), a.getKey());
				}
				return ret;
			});
			sb.append("#"+number+" "+entry.get(0).getKey()).append("\n");
		}
		System.out.println(sb);
	}
}