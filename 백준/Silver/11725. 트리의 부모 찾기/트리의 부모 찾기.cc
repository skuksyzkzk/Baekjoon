#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int p[100002];
vector<int> adj[100002];
int N;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	queue<int> q;
	for (int i = 0; i < N-1; i++) {
		int u, v;
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	p[1] = 0;
	q.push(1);
	while (!q.empty()) {
		int cur = q.front(); q.pop();
		for (auto nxt : adj[cur]) {
			if (p[cur] == nxt) continue;
			q.push(nxt);
			p[nxt] = cur;
		}
	}

	for (int i = 2; i <= N; i++) {
		cout << p[i] << "\n";
	}
	return 0;
}

