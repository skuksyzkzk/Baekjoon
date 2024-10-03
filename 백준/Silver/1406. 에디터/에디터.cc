#include <iostream>
#include <list>
#include <string>
using namespace std;



int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int M;
	string str;
	cin >> str;
	cin >> M;
	// 길이만큼 연결리스트 삽입 
	list<char> l;

	for (int i = 0; i < str.length(); i++) {
		l.push_back(str[i]);
	}
	list<char>::iterator cur = l.end();
	// 문자열 처리

	while (M--) {
		char a{ 'a' }, b{ '0' };
		cin >> a;
		// 커서 왼쪽이동
		if (a == 'L') {
			if (cur == l.begin()) {
				continue;
			}
			cur--;
		}
		// 커서 오른쪽 이동
		else if (a == 'D') {
			if (cur == l.end()) continue;
			cur++;
		}
		// 커서 왼쪽 삭제
		else if (a == 'B') {
			if (cur == l.begin()) continue;
			cur--;
			cur = l.erase(cur);
		}
		// 커서 왼쪽에 추가
		else if (a == 'P') {
			cin >> b;
			l.insert(cur, b);
		}
	}

	// 출력
	for (list<char>::iterator it = l.begin(); it != l.end(); it++) {
		cout << *it;
	}
	return 0;
}