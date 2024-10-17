#include <iostream>
#include <algorithm>
#include <stack>
#include <string>

using namespace std;
int n;
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n;
	int count = 0;
	for (int i = 0; i < n; i++) {
		stack<char> s;
		string str;
		cin >> str;
		bool no = 0;
		for (int j = 0; j < str.size(); j++) {
			if (!s.empty()) {
				char cur = s.top();
				if (str[j] == 'A' && cur == 'A') {
					s.pop();
				}
				else if (str[j] == 'B' && cur == 'B') s.pop();
				else {
					s.push(str[j]);
				}
			}
			else {
				s.push(str[j]);
			}
			
		}
		if (s.empty()) count++;
	}

	cout << count;
	return 0;
}