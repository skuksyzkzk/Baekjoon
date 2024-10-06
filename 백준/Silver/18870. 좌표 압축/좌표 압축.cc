#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int arr[1000002];

int main() {
	ios::sync_with_stdio(0); cin.tie(0); 
	int N;
	cin >> N;
	vector<int>tmp,uni;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
		tmp.push_back(arr[i]);
	}
	sort(tmp.begin(), tmp.end());
	
	for (int i = 0; i < N; i++) {
		if (i == 0 || tmp[i - 1] != tmp[i]) uni.push_back(tmp[i]);
		
	}

	for (int i = 0; i < N; i++) {
		cout << lower_bound(uni.begin(), uni.end(), arr[i]) - uni.begin() << " ";
	}
	
	
	return 0;
}