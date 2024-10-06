#include <iostream>
#include <queue>

using namespace std;

int dist[100002];
int N, K;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> K;

	queue<int> q;
	fill(dist, dist + 100001, -1);
	dist[N] = 0;
	q.push(N);

	while(dist[K] == -1){
		int cur = q.front(); q.pop();
		for (int nxt : {cur - 1, cur + 1, cur * 2}) {
			if (nxt < 0 || nxt>100000) continue;
			if (dist[nxt] >= 0) continue;
			dist[nxt] = dist[cur] + 1;
			q.push(nxt);
		}
	}

	cout << dist[K];
	return 0;
}