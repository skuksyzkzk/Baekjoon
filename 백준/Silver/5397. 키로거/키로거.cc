#include <iostream>
#include <list>
#include <string>

using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		int size = str.length();

		list<char> l;
		list<char>::iterator it = l.begin();
		
		for (int j = 0; j < size; j++) {
			if (str[j] == '<') {
				if (it != l.begin()) it--;
			}
			else if (str[j] == '>') {
				if (it != l.end()) it++;
			}
			else if (str[j] == '-') {
				if (it != l.begin()) {
					it--;
					it = l.erase(it);
				}
			}
			else {
				l.insert(it, str[j]);
			}
		}
		for (auto z : l) {
			cout << z;
		}
		cout << '\n';
	}

	
	return 0;
}