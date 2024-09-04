#include <iostream>
#include <algorithm>

using namespace std;

struct point {
	int x;
	int y;
};

bool cmp1(point a, point b) {
	if (a.x < b.x) return true;
	return false;
}


bool cmp2(point a, point b) {
	if (a.x == b.x) return a.y < b.y;  // x가 같으면 y를 비교
	return a.x < b.x;  // x가 다르면 x를 비교
}
int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n;
	point p[100001];
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> p[i].x >> p[i].y;
	}
	sort(p, p + n, cmp1);
	sort(p, p + n, cmp2);
	for (int j = 0; j < n; j++) {
		cout << p[j].x << " " << p[j].y << "\n";
	}

	return 0;
}