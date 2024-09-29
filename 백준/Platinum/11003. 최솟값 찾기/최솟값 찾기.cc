#include <iostream>
#include <deque>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N, L;
	deque<pair<int,int>> dq;

	cin >> N >> L;


	for (int i = 1; i < N + 1; i++) {
		pair<int, int> input;
		input.first = i;
		cin >> input.second;


		while (!dq.empty() && dq.back().second > input.second) {
			dq.pop_back();
		}
		dq.push_back(input);

		if (dq.front().first <= input.first - L) {
			dq.pop_front();
		}

		cout << dq.front().second << " ";


	}

	return 0;
}