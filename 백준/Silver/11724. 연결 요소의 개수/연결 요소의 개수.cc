#include<iostream>
#include <vector>
#include <stack>

using namespace std;

bool vis[1002];

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, M;
	cin >> N >> M;
	vector<int> adj[1002];
	stack<int> s;
	// 연결리스트 초기화
	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	int cnt = 0;
	// dfs 비재귀 
	for (int j = 1; j <= N; j++) {
		
		if (vis[j]) continue;
		s.push(j);
		cnt++;
		while (!s.empty()) {
			int cur = s.top(); s.pop();
			if (vis[cur]) continue;
			vis[cur] = 1;
			for (auto nxt : adj[cur]) {
				if (vis[nxt]) continue;
				s.push(nxt);
			}
		}
	}

	cout << cnt;
	return 0;
}