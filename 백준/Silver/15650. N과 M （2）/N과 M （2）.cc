#include <iostream>

using namespace std;
int N, M;
int print[10];
int vis[10];
void c(int k,int num) {
	if (k == M) {
		for (int i = 0; i < M; i++)
			cout << print[i] << ' ';

		cout << '\n';
	}

	for (int i = num; i <= N; i++) {
		if (!vis[i]) {
			print[k] = i;
			vis[i] = 1;
			c(k + 1,i+1);
			vis[i] = 0;
		}
	}
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> M;
	c(0,1);
	return 0;
}