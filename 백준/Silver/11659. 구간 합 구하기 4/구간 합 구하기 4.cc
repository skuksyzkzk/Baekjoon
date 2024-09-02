#include <iostream>
#include <vector>

using namespace std;
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, m, a, i, j;
	cin >> n >> m;
	vector<int> s;
	for (int k = 0; k < n; k++) {
		cin >> a;
		if (k == 0) s.push_back(a);
		else s.push_back(a + s[k-1]);
	}
	
	for (int c = 0; c < m; c++) {
		cin >> i >> j;
		if (i == 1) cout << s[j - 1] << "\n";
		else cout << s[j-1] - s[i - 2] << "\n";
		
	}
	return 0;
}