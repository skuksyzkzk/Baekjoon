import java.util.*;
import java.io.*;

class Main {
	static class Node {
		int x;
		int y;
		int h;
		public Node(int x,int y,int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
	private static int[] dx = {1,-1,0,0,0,0};
	private static int[] dy = {0,0,1,-1,0,0};
	private static int[] dh = {0,0,0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] board = new int[N][M][H];
		int[][][] dist = new int[N][M][H];
		ArrayDeque<Node> q = new ArrayDeque<>();
		// 초기화
		for (int i = 0 ; i< H;i++) {
			for (int j = 0; j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k= 0; k<M;k++) {
					int value = Integer.parseInt(st.nextToken());
					board[j][k][i] = value;
					if (value == 1) q.offer(new Node(j,k,i));
					if (value == 0) dist[j][k][i] = -1;
				}
			}
		}
		
		// bfs 6방향으로 진행 
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for (int dir = 0; dir < 6;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				int nh = cur.h + dh[dir];
				if (nx < 0 || nx >= N || ny <0 || ny >= M || nh < 0 || nh >= H) continue;
				if (board[nx][ny][nh] !=0 || dist[nx][ny][nh] >0 ) continue;
				dist[nx][ny][nh] = dist[cur.x][cur.y][cur.h] +1;
				q.offer(new Node(nx,ny,nh));
			}
		}
		// 순회하며 -1 이면 -1 출력 return
		int answer = 0;
		for (int i = 0 ; i< H;i++) {
			for (int j = 0; j<N;j++) {
				for (int k= 0; k<M;k++) {
					if (dist[j][k][i] == -1) {
						System.out.println(-1);
						return;
					}
					answer = Math.max(answer, dist[j][k][i]);
				}
			}
		}
		
		System.out.println(answer);
	}
}