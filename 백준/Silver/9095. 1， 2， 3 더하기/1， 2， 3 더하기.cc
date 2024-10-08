#include <iostream>

using namespace std;
int D[12];
int T;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	

	D[1] = 1; D[2] = 2; D[3] = 4;
	
	for (int i = 4; i < 11; i++) {
		D[i] = D[i - 1] + D[i - 2] + D[i - 3];
	}
	cin >> T;
	for (int i = 0; i < T; i++) {
		int input;
		cin >> input;
		cout << D[input] << "\n";
	}
	return 0;
}