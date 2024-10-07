#include <iostream>
#include <cmath>

using namespace std;

int K, N;
int arr[10005];
bool solve(long long x) {
	long long cur = 0;
	for (int i = 0; i < K; i++) {
		cur += (arr[i] / x);
	}
	return cur >= N;
}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	
	cin >> K >> N;
	// 길이를 일단 입력 받음 
	for (int i = 0; i < K; i++) {
		cin >> arr[i];
	}
	long long st = 1;
	long long ed = pow(2,31) - 1;
	while (st < ed) {
		long long mid = (st + ed + 1) / 2;
		if (solve(mid)) st = mid;
		else ed = mid - 1;
	}
	cout << st;

	return 0;
}