#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
	string str;
	int arr[26] = {0,};
	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		arr[int(str[i]) - 97]++;
	}
	for (int j = 0; j < 26; j++) {
		cout << arr[j] << " ";
	}
	return 0;
}