#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int N, M;
vector<int> v;
void bs(int t) {
	int st = 0;int ed = N -1;
	while (st <= ed) {
		int mid = (st + ed) / 2;
		if (v[mid] == t) {
			cout << 1 << "\n";
			return;
		}
		else if (v[mid] < t) st = mid + 1;
		else if (v[mid] > t) ed = mid - 1;
	}
	

	cout << 0 << "\n";
}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++) {
		int input;
		cin >> input;
		v.push_back(input);
	}
	sort(v.begin(), v.end());
	cin >> M;
	for (int j = 0; j < M; j++) {
		int input;
		cin >> input;
		bs(input);
	}
	

	return 0;
}
