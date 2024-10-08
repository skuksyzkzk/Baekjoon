#include <iostream>
#include <queue>

using namespace std;
int N;

int dist[1000002];

bool check(int n) {
	return n == 1;
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	fill(dist, dist + 1000002, -1);
	cin >> N;

	queue<int> q;
	q.push(N);
	dist[N] = 0;
	while (!q.empty()) {
		int cur = q.front(); q.pop();
		int first = cur / 3;
		int second = cur / 2;
		int third = cur - 1;
		if (cur % 3 == 0 && dist[first] <0) {
			dist[first] = dist[cur] + 1;
			if (check(first)) break;
			q.push(first);
			
		}
		if (cur % 2 == 0 && dist[second] < 0) {
			dist[second] = dist[cur] + 1;
			if (check(second)) break;
			q.push(second);
		}
		if (third > 0 && dist[third] < 0) {
			dist[third] = dist[cur] + 1;
			if (check(third)) break;
			q.push(third);
		}
		

	}
	cout << dist[1];
	return 0;
}