#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct cmp {
	bool operator()(int a, int b) {
		if (abs(a) > abs(b)) {
			return true;
		}
		else if (abs(a) == abs(b)) {
			if (a > b) return true;
			else return false;
		}
		return false;
	}
};
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;

	priority_queue<int, vector<int>, cmp> pq;

	int input{ 0 };
	for (int i = 0; i < N; i++) {
		cin >> input;

		if (input == 0) {
			if (pq.empty()) {
				cout << 0 << "\n";
			}
			else {
				cout << pq.top() << "\n";
				pq.pop();
			}
			
		}
		else {
			pq.push(input);
		}
		
	}
	

	return 0;
}