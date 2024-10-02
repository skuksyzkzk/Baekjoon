#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool cmp(const string& a, const string& b) {
	if (a.length() != b.length()) return a.length() < b.length();


	int suma = 0; int sumb = 0;
	for (int i = 0; i < a.length(); i++) {
		if (isdigit(a[i])) {
			suma += a[i] - '0';
		}
		if (isdigit(b[i])) {
			sumb += b[i] - '0';
		}
	}
	if (suma != sumb) return suma < sumb;



	return a < b;

}

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int N;
	cin >> N;

	vector<string> v(N, "");
	for (int i = 0; i < N; i++) {
		cin >> v[i];
	}
	sort(v.begin(), v.end(), cmp);

	for (auto z : v) cout << z << "\n";
	return 0;
}