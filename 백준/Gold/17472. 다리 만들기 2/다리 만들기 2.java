import java.util.*;
import java.io.*;

class Main {
	static class Node {
		int X,Y;
		public Node(int X,int Y) {
			this.X = X;
			this.Y = Y;
		}
		public String toString() {
			return "X:"+X+" Y:"+Y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int src , dest , cost;
		public Edge(int src,int dest,int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge other) {
			return Integer.compare(this.cost, other.cost);
		}
		public String toString() {
			return "src: "+src+" dest: "+dest+" cost: "+cost;
		}
	}
	static boolean isOut(int x,int y) {
		return (x < 0 || y < 0 || x >= N || y>=M);
	}
	static int[][] map;
	static ArrayList<Node>[] island;
	// 남 동 북 서 
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static int[] parent;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		//간선을 이용해서 풀기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		island = new ArrayList[7];
		// 각 섬들의 좌표를 저장 
		for (int i = 0 ; i <= 6;i ++) {
			island[i] = new ArrayList<>();
		}
		// 맵 입력 받기
		for (int i = 0 ; i < N; i++) {
			st  = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// BFS로 1부터 섬을 할당 
		ArrayDeque<Node> q  = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		
		int islandCnt = 0; // 섬의 갯수
		for (int i = 0 ; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					q.offer(new Node(i,j));
					islandCnt++;
					visited[i][j] = true;
					map[i][j] = islandCnt;
					island[islandCnt].add(new Node(i,j));
					while (!q.isEmpty()) {
						Node cur = q.poll();
						
						for (int dir = 0 ; dir < 4; dir++) {
							int nx = cur.X + dx[dir];
							int ny = cur.Y + dy[dir];
							if (isOut(nx,ny)) continue;
							if (visited[nx][ny] || map[nx][ny] != 1) continue;
							
							map[nx][ny] = islandCnt;
							visited[nx][ny] = true;
							q.offer(new Node(nx,ny));
							island[islandCnt].add(new Node(nx,ny));
						}
					}
				}
			}
		}
		
		q  = new ArrayDeque<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 해당 육지로부터 이어지는 간선들을 구해서 우선순위 큐에 집어넣고 합치기 
		for (int i = 1; i <= islandCnt; i++) {
			// 육지의 번호를 node로 생각하기
			int targetNumber = i;
			for (Node node : island[targetNumber]) {
				q.offer(node);
			}
			// 간선 구하기 
			// 동서남북 이동 4가지 방향으로 이동시에 해당 노드와 동일한 숫자 만나면 컷 
			// 0을 만나면 쭉 이동 후 다른 노드의 번호를 만나면 이전에 기록한 횟수가 2이상인지 확인후 
			// 2이상일 경우 우선순위 큐에 집어넣기 
			while (!q.isEmpty()) {
				Node cur = q.poll();
				
				for(int dir = 0; dir < 4;dir ++) {
					int nx = cur.X + dx[dir];
					int ny = cur.Y + dy[dir];
					if (isOut(nx,ny)) continue;
					if (map[nx][ny] != 0) continue;
					
					Edge bridge = findBridge(nx,ny,dir,targetNumber);
					// 길이 없을 경우
					if (bridge == null) {
						continue;
					}else {
						pq.offer(bridge);
					}
					
				}
			}
		}
		int selectedEdge = 0;
		// MST
		parent = new int[7];
		for (int i = 0; i <= 6 ; i++) {
			parent[i] = i;
		}
		long sum = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (find(cur.src) == find(cur.dest)) continue; 
			// 부모가 다를 경우에만 union	
			selectedEdge++;
			union(cur.src,cur.dest);
			sum+= cur.cost;
			if (selectedEdge == islandCnt-1) break;
			
		}
		System.out.println(selectedEdge != islandCnt-1 ? -1 : sum);
		
	}
	
	static Edge findBridge(int nx, int ny, int dir,int num) {
		// 주어진 위치에서 dir 방향으로 쭉 이동 
		// 이동시 다른 번호를 만날 경우 현재까지의 len 확인해서 2이상일 경우 return 
		// 아닐 경우 null 리턴하기
		int len = 0;
		while (map[nx][ny] == 0) {
			len++;
			nx += dx[dir];
			ny += dy[dir];
			if (isOut(nx,ny)) return null;
		}
		int anotherIsland = map[nx][ny];
		if (len >= 2 && anotherIsland != 0) return new Edge(num,anotherIsland,len);
		return null;
	}
	
	static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot) {
			parent[aRoot] = bRoot;
		}
	}
	
	static int find(int now) {
		if (parent[now] == now) return now;
		return parent[now] = find(parent[now]);
	}
	
}