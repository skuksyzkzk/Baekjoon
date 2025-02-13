import java.util.*;
import java.io.*;

class Main{
	static class Edge {
		int src,dest;
		long cost;
		public Edge (int src,int dest,long cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return src+" "+dest+" "+cost;
		}
	}
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int W,H;
	static ArrayList<Edge> adj;
	static long[] dist;
	static HashSet<Integer> ghost;
	static HashSet<Integer> hole; 
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) break;
			// 출구 노드 기록 
			int out = W*H -1;
			// 묘지 위치 기록 
			ghost = new HashSet<>();
			hole = new HashSet<>();
			adj = new ArrayList<>();
			int G = Integer.parseInt(br.readLine());
			
			for (int i = 0;  i< G;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				int node = x*W + y;
				ghost.add(node);
			}
			// 귀신의 구멍 기록 
			int E = Integer.parseInt(br.readLine());
			for (int i= 0 ; i< E; i++) {
				st = new StringTokenizer(br.readLine());
				int y1 = Integer.parseInt(st.nextToken());
				int x1 = Integer.parseInt(st.nextToken());
				
				int from = x1*W + y1;
				int y2 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int to = x2*W + y2;
				
				int c = Integer.parseInt(st.nextToken());
				hole.add(from);
				
				adj.add(new Edge(from,to,c));
			}
			// 간선 연결
			for (int x = 0 ; x < H; x++) {
				for (int y = 0; y < W; y++) {
					int node = x*W+y;
					// 시작이 묘비,귀신구멍, 출발지 일경우 건너띄기 
					if (ghost.contains(node) || hole.contains(node) || 
							out == node) continue;
					for (int dir = 0; dir < 4; dir ++) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						if (nx <0 || ny <0|| nx >= H || ny >= W) continue;
						int next = nx*W + ny;
						// 다음이 묘비면 건너띄기 
						if (ghost.contains(next)) continue;
						
						adj.add(new Edge(node,next,1));
					}
				}
			}
			// 과거로 계속 돌아간다 -> 음의 사이클 
			if (!BFM(0)) {
				sb.append("Never\n");
			}else {
				// 빠져나올수없다 -> 값이 MAX다
				if (dist[out] == Long.MAX_VALUE) sb.append("Impossible\n");
				// 그 외 출력
				else sb.append(dist[out]+"\n");	
			}
		}
		System.out.println(sb.toString());
	}
	private static boolean BFM(int st) {
		dist = new long[W*H];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[st] = 0;
		
		for (int i = 0 ; i < W*H - ghost.size() -1; i ++) {
			for (Edge edge : adj) {
				if (dist[edge.src] == Long.MAX_VALUE) continue;
				if (dist[edge.dest] > dist[edge.src] + edge.cost) {
					dist[edge.dest] = dist[edge.src] + edge.cost;
				}
			}
		}
		for (Edge edge : adj) {
			if (dist[edge.src] == Long.MAX_VALUE) continue;
			if (dist[edge.dest] > dist[edge.src] + edge.cost) {
				return false;
			}
		}
		
		return true;
	}

}