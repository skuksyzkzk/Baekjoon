#include <iostream>

using namespace std;
int N, S;
int arr[22];
int cnt = 0;
void c(int level, int total) {
	if (level == N) {
		if (total == S) cnt++;
		return;
	}

	c(level + 1, total);
	c(level + 1, total + arr[level]);

	

}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	c(0, 0);

	if (S == 0) cnt--;
	cout << cnt;
	return 0;
}