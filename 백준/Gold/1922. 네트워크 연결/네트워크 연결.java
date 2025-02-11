import java.util.*;
import java.io.*;

class Main {
	static class Edge implements Comparable<Edge>{
		int src , dest, cost;
		public Edge ( int src, int dest,int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	static int N;
	static PriorityQueue<Edge> pq;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		//간선을 이용해서 풀기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		parent = new int[N+1];
		
		for (int i = 0 ; i <= N ;i++) {
			parent[i] = i;
		}
		
		for (int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(src,dest,cost));
		}
		
		makeMST();
	
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot!=bRoot) {
			parent[aRoot] = bRoot;
		}
	}
	static int find(int now) {
		if (parent[now] == now) return now;
		return parent[now] = find(parent[now]);
	}
	
	static void makeMST() {
		int selected = 0;
		long sum = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (find(cur.src) == find(cur.dest)) continue;
			
			sum+= cur.cost;
			union(cur.src,cur.dest);
			
			if (selected == N-1) break;
			
		}
		System.out.println(sum);
	}
}