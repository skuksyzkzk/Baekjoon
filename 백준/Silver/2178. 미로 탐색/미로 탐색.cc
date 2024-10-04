#include <iostream>
#include <queue>
#include <string>
#define X first
#define Y second 

using namespace std;

bool vis[102][102];
int board[102][102];
int dist[102][102];

int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, M;
	cin >> N >> M;
	queue<pair<int, int>> q;
	int ds = 1;
	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < M; j++) {
			board[i][j] = str[j] -'0';
		}
	}

	vis[0][0] = 1;
	q.push({ 0,0 });
	dist[0][0] = ds;

	while (!q.empty()) {
		bool flag = 1;
		pair<int, int> cur = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (vis[nx][ny] || board[nx][ny] != 1) continue;
			
			vis[nx][ny] = 1;
			q.push({ nx,ny });
			dist[nx][ny] = dist[cur.X][cur.Y]+1;
		}
	}

	cout << dist[N - 1][M - 1];

}