#include <iostream>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n;
	cin >> n;

	/*
		N으로 숫자를 받으면 그거를 2개 숫자로 분해 
		n == 15 
		{1,14} 여기서 14 -2 = 12 , 12- 3= 9 ,9 -4 = 5 , 5 - 5= 0 이면 이게 한개 
		{2,13} 13 -3 = 10,10-4 = 6 , 6-5 =1 ,1-6= -5 , 음수나왔으니까 넘긴다 
	*/
	int count = 1; // 자기 자신인 경우니까 
	for (int i = 1; i <= n / 2; i++) {
		int remainder = n - i;
		for (int j = i + 1; j <= n; j++) {
			remainder -= j;
			if (remainder == 0) count++;
			else if (remainder < 0) break;
		}
	}

	cout << count;
	return 0;
}

