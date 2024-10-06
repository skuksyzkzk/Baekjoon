#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	vector<int> v(N,0);
	for (int i = 0; i < N; i++) {
		cin >> v[i];
	}

	sort(v.begin(), v.end());
	
	// 2개의 수의 합 배열 
	vector<int> two;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			two.push_back(v[i] + v[j]);
		}
	}
	two.erase(unique(two.begin(), two.end()), two.end());
	sort(two.begin(), two.end());
	int max{ 0 };
	for (int i = N-1; i > 0; i--) {
		for (int j = 0; j < i; j++) {
			if (binary_search(two.begin(), two.end(), v[i] - v[j])) {
				cout << v[i];
				return 0;
			}
		}
	}

	


	return 0;
}