#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <set>
#include <algorithm>
using namespace std;
int fst[26];
int snd[26];
int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	string str1;
	string str2;
	
	cin >> str1 >> str2;
	for (int i = 0; i < str1.size(); i++)
		fst[str1[i] - 'a']++;
	for (int i = 0; i < str2.size(); i++)
		snd[str2[i] - 'a']++;
	int sum = 0;
	for (int i = 0; i < 26; i++) {
		sum += abs(fst[i] - snd[i]);
	}

	cout << sum;
	
	return 0;
}