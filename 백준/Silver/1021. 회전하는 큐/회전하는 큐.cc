#include <iostream>
#include <algorithm>
#include <deque>

using namespace std;
int n, m;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n >> m;
	deque<int> dq;
	for (int i = 1; i <= n; i++) dq.push_back(i);
	int ans = 0;
	while (m--) {
		int target;
		cin >> target;
		int idx = find(dq.begin(), dq.end(), target) - dq.begin();
		while (dq.front() != target) {
			if (idx < dq.size() - idx) {
				dq.push_back(dq.front());
				dq.pop_front();
			}
			else {
				dq.push_front(dq.back());
				dq.pop_back();
			}
			ans++;
		}
		dq.pop_front();
	}

	cout << ans;
	return 0;
}