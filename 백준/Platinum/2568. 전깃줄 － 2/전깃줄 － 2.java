import java.util.*;
import java.io.*;

class Main {
	static class Edge {
		int a,b;
		public Edge (int a, int b) {
			this.a = a; 
			this.b = b;
		}
		public String toString() {
			return "a: "+a+" b: "+b;
		}
	}
	static ArrayList<Edge> adj;
	static int[] lis;
	static int[] trace;
	static boolean[] visited;
	public static void main (String[] args) throws IOException {
		// 전깃줄을 교차하지 않고 증가하는 방향으로 이어야 최대 갯수로 전깃줄을 교차 할 수있습니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 최장증가수열문제
		adj = new ArrayList<>();
		lis = new int[N];
		trace = new int[N];
		visited = new boolean[N];
		
		StringTokenizer st;
		for (int i = 0; i < N ; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj.add(new Edge(a,b));
		}
		Collections.sort(adj,(o1,o2) -> Integer.compare(o1.a, o2.a));
		// 주어진 A,B를 간선으로 만들어서 A를 기준으로 오름차순 정렬합니다.
		// 오름차순으로 정렬하여 결국 B로 이루어진 최장증가수열을 만들어야되는 문제입니다.
		// B를 기준으로 lis,inputs,trace 배열을 선언해서 해결합니다.
		lis[0] = adj.get(0).b;
		int idx = 0;
		for (int i = 1; i < adj.size(); i++) {
			if (lis[idx] < adj.get(i).b) {
				lis[++idx] = adj.get(i).b;
				trace[i] = idx;
			} else {
				int target = lowerBound(adj.get(i).b,idx);
				lis[target] = adj.get(i).b;
				trace[i] = target;
			}
		}
		int length = N - (idx+1);
		StringBuilder sb = new StringBuilder();
		sb.append(length+"\n");
		
		for (int i = N-1;i >= 0; i--) {
			if (trace[i] == idx) {
				idx--;
				visited[i] = true;
			}
		}
		for (int i = 0 ; i < N; i++) {
			if (!visited[i]) sb.append(adj.get(i).a+"\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int lowerBound(int find, int idx) {
		// TODO Auto-generated method stub
		int left = 0 ; int right = idx+1;
		while (left < right) {
			int mid = (left + right) / 2; 
			if (lis[mid]>= find ) right = mid;
			else left = mid + 1;
		}
		return right;
	}
}