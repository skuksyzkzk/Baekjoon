#include <iostream>

using namespace std;
int N, M;
int print[10];
int vis[10];
void p(int k) {
	if (k == M) {
		for (int i = 0; i < M; i++)
			cout << print[i] << ' ';

		cout << '\n';
	}

	for (int i = 1; i <= N; i++) {
		if (!vis[i]) {
			print[k] = i;
			vis[i] = 1;
			p(k + 1);
			vis[i] = 0;
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	p(0);
	return 0;
}