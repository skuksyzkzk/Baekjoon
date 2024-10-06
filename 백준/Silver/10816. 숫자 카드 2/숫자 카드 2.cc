#include <iostream>
#include <algorithm>

int arr[500002];
using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); 
	int N, M;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	
	sort(arr, arr + N);
	cin >> M; int inpu;
	for (int j = 0; j < M; j++) {
		cin >> inpu;
		cout << upper_bound(arr, arr + N, inpu) - lower_bound(arr, arr + N, inpu) << " ";
	}
	return 0;
}