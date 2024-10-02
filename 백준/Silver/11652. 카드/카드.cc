#include<iostream>
#include <map>
#include <algorithm>

using namespace std;


int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	map<long long, int> m;

	for (int i = 0; i < N; i++) {
		long long  input;
		cin >> input;
		m[input]++;
		
	}
	long long max_num = 0;
	int max_value = 0;
	
	for (auto& z : m) {
		if(z.second > max_value){
			max_value = z.second;
			max_num = z.first;
		}
	}

	cout << max_num;
	

	return 0;
}