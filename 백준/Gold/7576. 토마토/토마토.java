import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x ;
		int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	private static int[][] board;
	private static int[][] dist;
	private static int[] dx = {1,-1,0,0};
	private static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		dist = new int[N][M];
		ArrayDeque<Node> q = new ArrayDeque<>();
		// 입력 초기화 및 시작점 큐에 넣기
		for (int i = 0; i < N ;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				board[i][j] = value;
				if (value == 1) q.offer(new Node(i,j));
				if (value == 0) dist[i][j] = -1;
			}
		}
		// 각 시작점에서 BFS 시작 
		// 모든 토마토가 익어있다는 것은 1이거나 -1로 찬 상태 그러면 dist값은 전부 0 일거임 
		// 토마토가 모두 익지 못했다는 것 역시 0인 자리에 -1 이 저장되있으므로 -1 이면 -1 출력
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx <0 || nx >= N || ny <0 || ny >=M) continue;
				if (board[nx][ny] != 0 || dist[nx][ny] > 0) continue;
				dist[nx][ny] = dist[cur.x][cur.y] +1 ;
				q.offer(new Node(nx,ny));
			}
		}
		int answer = 0 ;
		for (int i =0; i< N; i++) {
			for (int j = 0; j<M;j++) {
				if (dist[i][j] == -1) {
					System.out.println(-1);
					return ;
				}
				answer = Math.max(answer,dist[i][j]);
			}
		}
		System.out.println(answer);
		
		
	}
}