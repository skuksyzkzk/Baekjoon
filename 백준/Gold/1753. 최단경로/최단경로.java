import java.util.*;
import java.io.*;

class Main {
	
	static class Edge implements Comparable<Edge>{
		int dest,cost;
		
		public Edge (int dest,int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	static ArrayList<Edge>[] adj;
	static int[] dist;
	static int V;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		adj = new ArrayList[V+1];
		
		for (int i = 0 ; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[src].add(new Edge(dest,cost));
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i]+"\n");
		}
		System.out.println(sb);
	}
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		boolean[] visited = new boolean[V+1];
		
		pq.offer(new Edge(start,0));
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(visited[cur.dest]) continue;
			
			visited[cur.dest] = true;
			
			for (Edge next : adj[cur.dest]) {
				if (dist[next.dest] > cur.cost + next.cost) {
					dist[next.dest] = cur.cost + next.cost;
					pq.offer(new Edge(next.dest,dist[next.dest]));
				}
			}
		}
		
	}
	
}
