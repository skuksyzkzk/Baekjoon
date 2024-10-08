#include <iostream>

using namespace std;
int N;
long long D[1002];
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> N;

	D[1] = 1; D[2] = 2; D[3] = 3;
	for (int i = 4; i <= N; i++) {
		D[i] = (D[i - 1] + D[i - 2]) % 10007;
	}

	cout << D[N];
	return 0;
}