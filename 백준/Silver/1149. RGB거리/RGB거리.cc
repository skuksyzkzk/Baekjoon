#include <iostream>

using namespace std;
int D[1005][3];// i번째가 최소값인거지, 빨 , 초 , 파 경우에 
int N;
int S[1005][3];
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> S[i][j];
		}
	}
	// s가 채워진거지 값들이 D 초기화
	D[1][0] = S[1][0]; D[1][1] = S[1][1]; D[1][2] = S[1][2];
	for (int i = 2; i <= N; i++) {
		D[i][0] = min(D[i - 1][1], D[i - 1][2]) + S[i][0];
		D[i][1] = min(D[i - 1][0], D[i - 1][2]) + S[i][1];
		D[i][2] = min(D[i - 1][0], D[i - 1][1]) + S[i][2];
	}

	cout << min(D[N][0], min(D[N][1], D[N][2]));
	return 0;
}