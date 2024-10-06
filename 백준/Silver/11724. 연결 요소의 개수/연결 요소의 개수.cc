#include<iostream>
#include <vector>
#include <queue>

using namespace std;

bool vis[1002];

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, M;
	cin >> N >> M;
	vector<int> adj[1002];
	queue<int> q;
	// 연결리스트 초기화
	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	int cnt = 0;
	// bfs 비재귀 
	for (int j = 1; j <= N; j++) {
		if (vis[j]) continue;
		q.push(j);
		vis[j] = 1;
		cnt++;
		while (!q.empty()) {
			int cur = q.front(); q.pop();
			for (auto nxt : adj[cur]) {
				if (vis[nxt]) continue;
				q.push(nxt);
				vis[nxt] = 1;
			}

		}
	}

	cout << cnt;
	return 0;
}