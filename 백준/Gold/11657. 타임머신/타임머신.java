import java.util.*;
import java.io.*;

class Main{
	static class Edge {
		int src,dest,cost;
		public Edge (int src,int dest,int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
	}
	static int N,M;
	static ArrayList<Edge> adj;
	static long[] dist;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList<>();
		dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj.add(new Edge(src,dest,cost));
		}
		StringBuilder sb = new StringBuilder();
		// 무한이 시간을 돌리는 경우
		if (!BFM(1)) {
			sb.append(-1);
			System.out.println(sb);
			return;
		}
		// 정상적인 상황
		for (int i = 2; i <= N; i++) {
			if (dist[i] == Long.MAX_VALUE) sb.append(-1+"\n");
			else sb.append(dist[i] + "\n");
		}
		
		System.out.println(sb.toString());
	}

	private static boolean BFM(int st) {
		// TODO Auto-generated method stub
		dist[st] = 0;
		
		for (int i = 0; i < N-1; i++) {
			
			for (Edge edge : adj) {
				if (dist[edge.src] == Long.MAX_VALUE) continue;
				if (dist[edge.dest] > dist[edge.src] + edge.cost) {
					dist[edge.dest] = dist[edge.src] + edge.cost;
				}
			}
		}
		// 음의 사이클
		for (Edge edge : adj) {
			if (dist[edge.src] == Long.MAX_VALUE) continue;
			if (dist[edge.dest] > dist[edge.src] + edge.cost) {
				return false;
			}
		}
		
		return true;
	}
}