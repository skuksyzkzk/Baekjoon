import java.util.*;
import java.io.*;

class Main {
	static class Point {
		int X,Y;
		public Point (int x, int y) {
			this.X = x;
			this.Y = y;
		}
	}
	static ArrayList<Integer> sortedStemina;
	static char[][] map;
	static int[][] stemina;
	static int N;
	static int[] dx = {0,1,0,-1,1,1,-1,-1};
	static int[] dy = {1,0,-1,0,1,-1,-1,1};
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int house = 0;
		Point office = null;
		// 지도 
		map = new char[N][N];
		for (int i = 0 ; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (c[j] == 'P') office = new Point(i,j);
				if (c[j] == 'K') house++;
				map[i][j] = c[j];
			}
		}
		// 피로도 행렬 
		stemina = new int[N][N];
		for (int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stemina[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 피로도 행렬을 오름차순으로 정렬
		sortedStemina = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sortedStemina.add(stemina[i][j]);
			}
		}
		Collections.sort(sortedStemina);
		int answer = sortedStemina.get(sortedStemina.size()-1) - sortedStemina.get(0);
		
		int lt = 0, rt = binarySearch(stemina[office.X][office.Y]);
		// BFS 진행
		while (lt <= rt && lt != sortedStemina.size() && rt != sortedStemina.size()) {
			int max = sortedStemina.get(rt);
			int min = sortedStemina.get(lt);
			if (min > stemina[office.X][office.Y]) break;
			// bfs값이 false rt++;
			if (!bfs(max,min,office,house)) {
				rt++;
			}
			// true 면 lt++ 최솟값 갱신
			else {
				answer = Math.min(answer, max-min);
				lt++;
			}
		}
		System.out.println(answer);
		
		
	}
	static int binarySearch(int find) {
		int left = 0, right = sortedStemina.size();
		while (left < right) {
			int mid = (left+right)/2;
			if (sortedStemina.get(mid) == find) return mid;
			else if (sortedStemina.get(mid) > find) right = mid -1;
			else left = mid + 1;
		}
		return left;
	}
	static boolean bfs(int max, int min, Point office,int kTotal) {
		ArrayDeque<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		visited[office.X][office.Y] = true;
		q.add(office);
		int cnt = 0;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int dir = 0; dir < 8; dir++) {
				int nx = cur.X + dx[dir];
				int ny = cur.Y + dy[dir];
				if ( nx < 0 || ny < 0 || nx >= N || ny >=N ) continue;
				if (visited[nx][ny]) continue;
				// 방문하지 못하는 범위
				if (stemina[nx][ny] >= min && stemina[nx][ny] <= max ) {
					// K 이면 
					if (map[nx][ny] == 'K') {
						cnt++;
					}
					// q에 삽입
					q.offer(new Point(nx,ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		return cnt == kTotal ? true : false;
	}
}