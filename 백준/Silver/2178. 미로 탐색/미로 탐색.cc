#include <iostream>
#include <vector>
#include <string>
#include <queue>

#define X first
#define Y second 

using namespace std;
int n, m;
int board[102][102];
int dist[102][102];

int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		fill(dist[i], dist[i] + m, -1);
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			board[i][j] = str[j] - '0';
		}
	}
	
	queue<pair<int, int>> q;
	q.push({ 0,0 });
	dist[0][0] = 1;

	while (!q.empty()) {
		pair<int, int> cur = q.front(); q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int nx = cur.X + dx[dir];
			int ny = cur.Y + dy[dir];
			if (nx < 0 || nx >= n || ny < 0 || ny >=m ) continue;
			if (board[nx][ny] != 1 || dist[nx][ny] > 0) continue;
			q.push({ nx,ny });
			dist[nx][ny] = dist[cur.X][cur.Y] + 1;
		}
	}

	cout << dist[n - 1][m - 1];
	
	return 0;
}