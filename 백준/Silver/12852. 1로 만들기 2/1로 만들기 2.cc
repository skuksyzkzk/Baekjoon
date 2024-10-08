#include <iostream>
#include <vector>
#include <algorithm>

#define MAX 10000000;
using namespace std;
int N;
int D[1000005];// 1로 만드는 최소한의 횟수
int pre[1000005];
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> N;
	D[1] = 0; pre[1] = 0;
	
	for (int i = 2; i <= N; i++) {
		D[i] = D[i - 1] + 1;
		pre[i] = i - 1;
		if (i % 2 == 0 && D[i] > D[i / 2] + 1) {
			D[i] = D[i / 2] + 1;
			pre[i] = i / 2;
		}
		if (i % 3 == 0 && D[i] > D[i / 3] + 1) {
			D[i] = D[i / 3] + 1;
			pre[i] = i / 3;
		}
	}
	int cur = N;
	cout << D[cur] << "\n";
	while (N--) {
		cout << cur << " ";
		if (cur == 1) break;
		cur = pre[cur];
	}
	return 0;
}