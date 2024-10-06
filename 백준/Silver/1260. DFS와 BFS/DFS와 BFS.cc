#include<iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>
using namespace std;

bool visD[1002];
bool visB[1002];
int main() {

	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, M, V;
	cin >> N >> M >> V;
	vector<int> adjD[1002];
	vector<int> adjB[1002];
	queue<int> q;
	stack<int> s;
	// 연결리스트 초기화
	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		adjD[u].push_back(v);
		adjD[v].push_back(u);
		adjB[u].push_back(v);
		adjB[v].push_back(u);
	}
	for (int k = 1; k <=N; k++) {
		sort(adjD[k].begin(), adjD[k].end(),greater<int>());
		sort(adjB[k].begin(), adjB[k].end());
	}
	int cnt = 0;
	// dfs 비재귀
	s.push(V);
	while (!s.empty()) {
		int cur = s.top(); s.pop();
		if (visD[cur]) continue;
		visD[cur] = 1;
		cout << cur << " ";
		for (auto nxt : adjD[cur]) {
			if (visD[nxt])continue;
			s.push(nxt);
		}

	}
	cout << "\n";
	// bfs 비재귀 
	q.push(V);
	visB[V] = 1;
	while (!q.empty()) {
		int cur = q.front(); q.pop();
		cout << cur << " ";
		for (auto nxt : adjB[cur]) {
			if (visB[nxt])continue;
			visB[nxt] = 1;
			q.push(nxt);
		}
		
	}
	
	return 0;
}