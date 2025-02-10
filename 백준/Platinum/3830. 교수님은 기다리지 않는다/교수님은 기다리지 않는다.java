import java.util.*;
import java.io.*;

class Main {
	// 상근이가 무게잰다.
	static void union(int a,int b,int w) {
		// b a 할 경우 a의 부모를 b로 잡고 a값을 갱신한다.
		int aRoot = calSum(a);
		int bRoot = calSum(b);
		
		long aW = weight[a];
		long bW = weight[b] + w;
		// b가 a 보다 크다.
		if (bW >= aW) {
			long offset = bW - aW;
			parent[aRoot] = bRoot;
			weight[aRoot] = offset;
			
		}else {
			long offset = aW - bW;
			parent[bRoot] = aRoot;
			weight[bRoot] = offset;
		}
	}
	// a b의 값의 차이 찾기 
	static void find(int a,int b) {
		// 서로의 루트가 다르다.
		// unkown리턴 
		if (calSum(a) != calSum(b)) {
			sb.append("UNKNOWN\n");
			return;
		}
		// 서로의 루트가 같다.
		// 루트가 같으면 각자의 위치부터 시작하면서 루트 만날때까지 값 더하기
		// aSum - bSum 값 리턴 
		else {
			sb.append(weight[a]-weight[b]+"\n");
			return;
		}

	}
	private static int calSum(int now) {
		long sum = findGo(now);
		int p = findP(now);
		return p;
	}
	static int findP(int now) {
		if (parent[now] == now) return now;
		return parent[now] = findP(parent[now]);
	}
	private static long findGo (int now) {
		if (parent[now] == now) return 0;
		return weight[now] = weight[now] + findGo(parent[now]);
	}

	static int[] parent; // 바로 자기 자신의 부모
	static long[] weight; // 부모와의 차이
	static StringBuilder sb;
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		sb =new StringBuilder();
		
		while (true) {
			st  =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N ==0 || M==0) break;
			parent = new int[N+1];
			weight = new long[N+1];

			for (int i = 0; i < N+1; i++) {
				parent[i] = i;
			}
			for (int i = 0; i< M;i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if ("!".equals(cmd)) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					int w = Integer.parseInt(st.nextToken());
					
					union(a,b,w);
				}else if ("?".equals(cmd)) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					find(a,b);
				}
			}
		}
		System.out.println(sb.toString());
		
		
	}
}