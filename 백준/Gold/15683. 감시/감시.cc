#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N, M;
int minimum = 0x7fffffff;

vector<pair<int, int>> cctvs;
int arr[8][8];


int dx[4] = {0,-1,0,1};
int dy[4] = {1,0,-1,0};

void check(int x, int y, int dir) {
	dir %=4;

	while (1) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		x = nx;
		y = ny;
		if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;
		if (arr[nx][ny] == 6) return;
		if (arr[nx][ny] != 0) continue;
		arr[nx][ny] = -1;
		
	}

}
void dfs(int level) {
	if (level == cctvs.size()) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!arr[i][j] ) cnt++;
			}
		}

		minimum = min(minimum, cnt);
		return;
	}
	int x = cctvs[level].first;
	int y = cctvs[level].second;
	int temp[9][9];
	for (int dir = 0; dir < 4; dir++) {
		// 배열 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		

		if (arr[x][y] == 1) {
			check(x, y, dir);
		}
		else if (arr[x][y] == 2) {
			check(x, y, dir);
			check(x, y, dir + 2);
		}
		else if (arr[x][y] == 3) {
			check(x, y, dir);
			check(x, y, dir + 1);
		}
		else if (arr[x][y] == 4) {
			check(x, y, dir);
			check(x, y, dir + 1);
			check(x, y, dir + 2);
		}
		else if (arr[x][y] == 5) {
			check(x, y, dir);
			check(x, y, dir + 1);
			check(x, y, dir+2);
			check(x, y, dir + 3);
		}

		dfs(level + 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp[i][j];
			}
		}

	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	// 초기화 
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			if (arr[i][j] != 0 && arr[i][j] != 6) {
				cctvs.push_back({ i,j });
			}
		}
	}
	
	dfs(0);

	cout << minimum;

	return 0;
}