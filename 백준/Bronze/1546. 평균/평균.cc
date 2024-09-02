#include <iostream>
#include <vector>

using namespace std;
int main() {
	int n,a,max;
	double average =0.0;

	vector<int> v;
	max = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		v.push_back(a);
		if (max <= a) max = a;
	}

	for (int j = 0; j < n; j++) {
		average += ((double)v[j] / max) * 100;
		
	}
	cout << average / (double)n;

	

	return 0;
}