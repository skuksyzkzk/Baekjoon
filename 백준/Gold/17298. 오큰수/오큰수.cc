#include <iostream>
#include <stack>
#include <vector>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	vector<int> gvn(N,0);
	vector<int> rt(N,0);
	stack<int> st;

	// 주어진 수 입력 다받기 인덱스로 
	for (int i = 0; i < N; i++) {
		cin >> gvn[i];
	}

	// 초기 스택 
	st.push(0);
	// 스택 계산 
	for (int j = 1; j < N; j++) {
		while (!st.empty() && gvn[st.top()] < gvn[j]) {
			rt[st.top()] = gvn[j];
			st.pop();
		}
		st.push(j);
	}
	
	// 스택에 남아있는 인덱스 값에 -1 채우기 
	while (!st.empty()) {
		rt[st.top()] = -1;
		st.pop();
	}

	for (auto z : rt) {
		cout << z << " ";
	}
	return 0;
}