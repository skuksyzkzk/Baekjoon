#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	
	vector<long long> v(N,0);

	for (int i = 0; i < N; i++) {
		cin >> v[i];
	}

	sort(v.begin(), v.end());

	long long mx = 0, mx_num = 0;
	long long result = v[0];

	for (int j = 1; j < N; j++) {
		if (v[j] == v[j - 1]) {
			mx_num++;
			if (mx_num > mx) {
				mx = mx_num;
				result = v[j];
			}
		}
		else mx_num = 0;
	}

	cout << result;
	return 0;
}