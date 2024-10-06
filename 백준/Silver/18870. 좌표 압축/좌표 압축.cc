#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int arr[1000002];

int main() {
	ios::sync_with_stdio(0); cin.tie(0); 
	int N;
	cin >> N;
	vector<int>tmp;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		tmp.push_back(arr[i]);
	}
	sort(tmp.begin(), tmp.end());
	
	tmp.erase(unique(tmp.begin(), tmp.end()), tmp.end());


	for (int i = 0; i < N; i++) {
		cout << lower_bound(tmp.begin(), tmp.end(), arr[i]) - tmp.begin() << " ";
	}
	
	
	return 0;
}