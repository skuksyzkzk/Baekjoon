#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <list>
#include <queue>
using namespace std;
int n,k;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n >> k;
	queue<int> q;
	for (int i = 1; i <= n; i++) {
		q.push(i);
	}
	cout << "<";
	while (q.size() > 1) {
		for (int i = 0; i < k; i++) {
			if (i == k - 1) {
				cout << q.front() << ", ";
				q.pop();
			}
			else {
				q.push(q.front());
				q.pop();
			}

		}

	}
	cout << q.front() << ">";
	return 0;
}