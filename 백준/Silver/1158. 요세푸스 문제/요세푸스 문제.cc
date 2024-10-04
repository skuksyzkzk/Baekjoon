#include <iostream>
#include <list>

using namespace std;

int main() {
	int N, K;
	cin >> N >> K;

	list<int> l;
	for (int i = 1; i <= N; i++) {
		l.push_back(i);
	}

	list<int>::iterator it = l.begin();

	
	cout << "<";
	while (!l.empty()) {
		int size = K - 1;
		while (size--) {
			it++;
			if (it == l.end()) it = l.begin();
		}

		
		for (list<int>::iterator t = l.begin(); t != l.end(); t++) {
			if (l.size() == 1) {
				cout << *it << ">";
			}
			else if (t == it) {
				cout << *it << ", ";
			}

		}
		it = l.erase(it);
		
		if (it == l.end()) {
			it = l.begin();
		}
		
	}

	
	return 0;
}