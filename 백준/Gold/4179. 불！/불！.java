import java.util.*;
import java.io.*;

class Main {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int[][] fireDist;
	private static int[][] jhDist;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] board = new char[R][C];
		fireDist = new int[R][C];
		jhDist = new int[R][C];
		ArrayDeque<Node> fq = new ArrayDeque<>();
		ArrayDeque<Node> jq = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char v = s.charAt(j);
				board[i][j] = v;
				if (v == 'J')
					jq.offer(new Node(i, j));
				if (v == 'F')
					fq.offer(new Node(i, j));
			}
		}
		// 불먼저 진행 시간을 저장한다.
		while (!fq.isEmpty()) {
			Node cur = fq.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || nx >= R || ny <0 || ny >= C) continue;
				if (board[nx][ny] != '.' || fireDist[nx][ny] > 0) continue;
				fireDist[nx][ny] = fireDist[cur.x][cur.y] +1 ;
				fq.offer(new Node(nx,ny));
			}
		}

		// 지훈이가 시작할때 불의 시간보다 작아야지 통과
		// 범위 밖으로 나가면 그때 cost 출력 만약에 q가 엠티 될때까지 못나가면 IMPOSSIBLE출력
		while (!jq.isEmpty()) {
			Node cur = jq.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				if (nx < 0 || nx >= R || ny <0 || ny >= C) {
					System.out.println(jhDist[cur.x][cur.y] +1 );
					return;
				}
				if (board[nx][ny] != '.' || jhDist[nx][ny] > 0) continue;
				if (fireDist[nx][ny] > 0 &&fireDist[nx][ny] <= jhDist[cur.x][cur.y] +1) continue;
				jhDist[nx][ny] = jhDist[cur.x][cur.y] +1 ;
				jq.offer(new Node(nx,ny));
			}
		}
		System.out.println("IMPOSSIBLE");

	}
}