#include <iostream>
#include <queue>

#define X first
#define Y second

using namespace std;

int board[502][502];
bool vis[502][502];
// 상하 좌우 
int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,-1,1 };
queue<pair<int, int>> q;
int N, M;
int bfs() {
	int size = 0;
	while (!q.empty()) {
		size++;
		pair<int, int> cur = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (vis[nx][ny] || board[nx][ny] != 1) continue;
			vis[nx][ny] = 1;
			q.push({ nx,ny });
		}
	}
	return size;
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
		}
	}
	int num = 0;
	int max = 0;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			pair<int, int> p;
			if (board[i][j] == 1 && !vis[i][j]) {
				num++;
				vis[i][j] = 1;
				q.push({ i,j });
				int tmp = bfs();
				if (tmp > max) max = tmp;
			}
		}
	}

	cout << num << "\n" << max;
	
	

	return 0;
}
