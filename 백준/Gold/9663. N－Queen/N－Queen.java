import java.util.*;
import java.io.*;

class Main {
	static boolean[][] board;
	static boolean[] col;
	static int N;
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		board = new boolean[N][N];
		col = new boolean[N];
		
		// 첫번째 행 부터 시작해서 놓는다.
		for (int i = 0 ; i < N ;i++) {
			col[i] = true;
			board[0][i] = true;
			// 해당 열에 놓고 다음 깊이로 들어가서 확인 
			dfs(1);
			col[i] = false;
			board[0][i] = false;
		}
		System.out.println(answer);
	}
	// 백트래킹 하며 퀸을 놓을 수 있는지 확인한다.
	private static void dfs(int depth) {
		// 만약 끝 깊이 이면 return 
		if (depth == N) {
			answer++;
			return;
		}
		
		for (int next = 0 ; next < N; next++) {
			// 해당 열에 퀸이 없을 경우만 
			if (!col[next]) {
				// 왼쪽 대각선 위에 퀸이 없을 때 && 우측 대각선 위 역시 없을 때
				if (!isLeftUp(next,depth) && !isRightUp(next,depth)) {
					col[next] = true;
					board[depth][next] = true;
					dfs(depth+1);
					col[next] = false;
					board[depth][next] = false;
				}
				
			}
		}
	}
	private static boolean isRightUp(int next,int depth) {
		// 우측 끝 인경우 체크 안함
		if (next == N-1) return false;
		else {
			int i = depth - 1; int j = next + 1;
			while (i >= 0 && j >= 0 && j < N) {
				if (board[i][j]) return true;
				i--; j++;
			}
		}
		return false;
	}
	private static boolean isLeftUp(int next,int depth) {
		// 왼쪽 끝 인경우 체크 안함 
		if (next == 0) return false;
		else {
			int i = depth-1; int j = next-1;
			while (i >= 0 && j >= 0) {
				if (board[i][j]) return true;
				i--; j--;
			}
		}
		return false;
	}
}