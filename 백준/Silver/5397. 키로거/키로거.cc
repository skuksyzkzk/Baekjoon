#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <list>
using namespace std;
int n;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		string str;
		list<char> lst;
		cin >> str;
		auto it = lst.begin(); // 커서 맨뒤 
		for (int j = 0; j < str.size(); j++) {
			if (str[j] != '<' && str[j] != '>' && str[j] != '-')
				lst.insert(it,str[j]);

			if (str[j] == '<' && it != lst.begin()) {
				it--;
			}
			else if (str[j] == '>' && it!=lst.end()) {
				it++;
			}
			else if (str[j] == '-' && it!=lst.begin()) {
				it--;
				it = lst.erase(it);
			}
			
		}
		for (auto nxt : lst) cout << nxt;

		cout << "\n";
	}
	return 0;
}