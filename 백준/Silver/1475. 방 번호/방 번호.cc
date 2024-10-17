#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n;
vector<int> v(10, 0);
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n;

	while (n != 0) {
		v[n % 10]++;
		n /= 10;
	}
	
	int sn_sum = (v[6] + v[9] + 1) / 2;

	int max_num = 0;

	for (int i = 0; i < 10; i++) {
		if (i == 6 || i == 9) continue;
		if (max_num < v[i]) max_num = v[i];
	}


	cout << max(max_num, sn_sum);

	return 0;
}