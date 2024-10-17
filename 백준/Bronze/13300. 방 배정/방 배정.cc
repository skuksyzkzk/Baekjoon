#include <iostream>
#include <vector>

using namespace std;
int man[7];
int women[7];
int N, K;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N >> K;

	int a, b;
	for (int i = 0; i < N; i++) {
		cin >> a >> b;
		if (a == 0) {
			women[b]++;
		}
		else if (a == 1) {
			man[b]++;
		}
	}

	int offset = K - 1;
	int sum = 0;
	for (int i = 1; i <= 6; i++) {
		if (women[i] > 0) {
			if (women[i] % K == 0) {
				sum += women[i] / K;
			}
			else sum += (women[i] + offset) / K;
		}
		if (man[i] > 0) {
			if (man[i] % K == 0) {
				sum += man[i] / K;
			}
			else sum += (man[i] + offset) / K;
		}
		
	}

	cout << sum;
	return 0;
}