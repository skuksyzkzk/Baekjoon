#include <iostream>
#include <stack>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int K;
	stack<int> st;
	cin >> K;
	int sum{ 0 };
	for (int i = 0; i < K; i++) {
		int input{ 0 };
		cin >> input;

		if (input == 0) {
			sum -= st.top();
			st.pop();
		}
		else {
			sum += input;
			st.push(input);
		}
	}
	cout << sum;
	return 0;
}