#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, m;
	cin >> n;
	cin >> m;
	vector<int> arr(n);
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	sort(arr.begin(),arr.end());

	int start{ 0 }, end{ n -1 }, count{ 0 };

	while (start < end ) {
		int sum = arr[start] + arr[end];
		if (sum == m) {
			count++;
			start++;
			end--;
			
		}
		else if (sum > m) {
			end--;
		}
		else if (sum < m) {
			start++;
		}
	}
	cout << count;
	
	return 0;
}