#include <iostream>

using namespace std;

int N;
int cnt = 0;
int col[17];

bool check(int level) {
	for (int i = 0; i < level; i++) {
		if (col[i] == col[level] || abs(level - i) == abs(col[level] - col[i]))
			return false;
	}
	return true;
}

void nqeen(int level) {
	if (level == N) {
		cnt++;
	}
	else {
		for (int i = 0; i < N; i++) {
			col[level] = i;
			if (check(level))
				nqeen(level + 1);

		}
	}
	

}
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	cin >> N;
	nqeen(0);

	cout << cnt;
	return 0;
}