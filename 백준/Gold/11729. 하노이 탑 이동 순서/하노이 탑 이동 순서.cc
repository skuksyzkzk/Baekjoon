#include <iostream>

using namespace std;
void hanoiFuckyou(int a, int b, int n) {
	if (n == 1) {
		cout << a << " " << b << "\n";
		return;
	}
	hanoiFuckyou(a, 6 - a - b, n - 1);
	cout << a << " " << b << "\n";
	hanoiFuckyou(6 - a - b, b, n - 1);
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	cout << (1 << N) - 1 << '\n';
	hanoiFuckyou(1, 3, N);
	return 0;
}