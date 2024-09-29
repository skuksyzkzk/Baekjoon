#include <vector>
#include <iostream>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int str_len, pass_len;
	string str;

	cin >> str_len >> pass_len;
	cin >> str;

	int x, y,ans=0;
	vector<int> key(100,0);
	vector<int> ACGT(100,0);
	
	cin >> key['A'];
	cin >> key['C'];
	cin >> key['G'];
	cin >> key['T'];

	x = 0;
	y = x + pass_len - 1;

	for (int j = x; j <= y; j++) {
		ACGT[str[j]]++;
	}

	while (y < str.size()) {
		if (key['A'] <= ACGT['A'] && key['C'] <= ACGT['C'] && 
			key['G'] <= ACGT['G'] && key['T'] <= ACGT['T']) {
			ans++;
		}
		ACGT[str[x++]]--;
		ACGT[str[++y]]++;
	}

	cout << ans;
	
	return 0;
}