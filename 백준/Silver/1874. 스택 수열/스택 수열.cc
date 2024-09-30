#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	vector<char> result;
	vector<int> given;
	stack<int> st;
	int input;
	cin >> N;
	// 주어진 수 입력
	for (int i = 0; i < N; i++) {
		cin >> input;
		given.push_back(input);
	}
	// 스택 연산 시작
	int num = 1;

	for (int j = 0; j < N; j++) {
		int cu = given[j];
		if (cu >= num) {
			while (cu >= num) {
				st.push(num++);
				result.push_back('+');
			}
			if (st.top() == cu) {
				st.pop();
				result.push_back('-');
			}
		}
		else if (!st.empty() && cu < num) {
			int top = st.top();
			if (top != cu) {
				cout << "NO";
				return 0;
			} 
			else if (top == cu) {
				st.pop();
				result.push_back('-');
			}
			
		}
	}
	
	for (auto z : result) {
		cout << z << "\n";
	}

	return 0;
}
