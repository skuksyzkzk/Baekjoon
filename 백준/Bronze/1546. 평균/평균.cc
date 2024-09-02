#include <iostream>
#include <vector>

using namespace std;
int main() {
	int n,a,max;
	max = 0;
	int sum = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		sum += a;
		if (max <= a) max = a;
	}

	cout << (double)sum / max * 100 / n;
	
	

	return 0;
}