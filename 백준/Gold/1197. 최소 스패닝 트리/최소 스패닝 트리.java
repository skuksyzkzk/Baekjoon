import java.util.*;

import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
		int answer = 0;
		
		ArrayList<int[]>[] adj = new ArrayList[V+1];
		for ( int i = 0 ; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i <E ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[a].add(new int[] {b,cost});
			adj[b].add(new int[] {a,cost});
		}
		
		boolean[] visited = new boolean[V+1];
		pq.add(new int[] {1,0});
	
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			answer += cur[1];
			
			for (int[] next : adj[cur[0]]) {
				if (!visited[next[0]]) pq.add(new int[] {next[0],next[1]});
			}
		}
		System.out.println(answer);
	}
}