#include <iostream>

using namespace std;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, m,input;
	cin >> n >> m;
	long long s[1000001] = {0,};
	long long r[1001] = {0,};
	for (int i = 0; i < n; i++) {
		cin >> input;
		if (i == 0) s[i] = input;
		else s[i] = s[i - 1] + input;
	}
	/* 
		모듈러 연산 일정 구간합을 M으로 나눈게 0 
		즉 (S[j] - S[i]) % M == 0 이것도 구간의 합 
		S[j] % M = S[i] % M 이 같으면 나누어 떨어지는 것 
		그리고 이것은 J가 커야됨 같거나 그렇기에 조합으로 푼다
		순열은 1 2 그룹이면 12,21 두개 순서가 중요 
		조합은 중요치 않고 쌍이기에 12 
		nC2 = n * n-1 /2  
		나머지 배열을 만든다 
		
	*/

	long long count = 0;
	for (int j = 0; j < n; j++) {
		long long remain = s[j] % m;
		if (remain == 0) count++;
		
		r[remain]++;
	}
	// remainder 배열에서 같은 수중2개를 뽑음 
	for (int q = 0; q < m; q++) {
		if (r[q] !=0) count += ((r[q] * (r[q] - 1)) / 2);
		
	}
	
	cout << count;
	return 0;
}