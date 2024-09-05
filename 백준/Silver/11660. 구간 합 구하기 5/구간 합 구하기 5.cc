#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, m,input;
	cin >> n >> m;
	vector<vector<int>> arr(n+1, vector<int>(n+1, 0));
	vector<vector<int>> s(n + 1, vector<int>(n + 1, 0));

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> input;
			s[i][j] = s[i - 1][j] + s[i][j - 1] + input - s[i - 1][j - 1];
		}
	}

	for (int k = 0; k < m; k++) {
		int x1, y1, x2, y2, sum = 0;
		cin >> x1 >> y1 >> x2 >> y2;
		cout << s[x2][y2] + s[x1-1][y1-1] - s[x1 - 1][y2] - s[x2][y1 - 1] << "\n";
	}
	return 0;
}