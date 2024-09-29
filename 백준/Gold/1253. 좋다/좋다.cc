#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;


int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n{ 0 };
	vector<long long> v;
	
	cin >> n;

	for (int i = 0; i < n; i++) {
		int input;
		cin >> input;
		v.push_back(input);
	}

	sort(v.rbegin(), v.rend());
	
	int good{ 0 };
	for (int k = 0; k < n; k++) {
		int find = v[k];
		int left{ 0 };
		int right{ n - 1 };

		while (left < right) {
			if (v[k] == v[left] + v[right]) {
				if (left != k && right != k) {
					good++;
					break;
				}
				else if (left == k) {
					left++;
				}
				else if (right == k) {
					right--;
				}
			}
			else if (v[k] > v[left] + v[right]) {
				right--;
			}
			else left++;
		}
	}
	cout << good;

	return 0;
}