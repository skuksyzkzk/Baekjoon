#include <iostream>
#include <stack>
#include <string>


using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	stack<int> st;
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		if (str == "push") {
			int v;
			cin >> v;
			st.push(v);
		}
		else if (str == "top") {
			if (st.empty()) cout << -1 << "\n";
			else cout << st.top() << "\n";
		}
		else if (str == "size") {
			cout << st.size() << "\n";
		}
		else if (str == "empty") {
			if (st.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (str == "pop") {
			if (st.empty()) cout << -1 << "\n";
			else {
				cout << st.top() << "\n";
				st.pop();
			}
		}
	}

	return 0;
}