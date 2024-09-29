#include <iostream>
#include <deque>

using namespace std;

struct Score {
	int index;
	int value;
};

int main() {
	ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);

	int N, L;
	deque<Score> dq;

	cin >> N >> L;

	for (int i = 1; i <= N; i++) {
		Score input;
		input.index = i;
		cin >> input.value;

		// 덱에서 뒤쪽 원소가 현재 입력 값보다 크면 제거
		while (!dq.empty() && dq.back().value > input.value) {
			dq.pop_back();
		}

		// 현재 값을 덱에 삽입
		dq.push_back(input);

		// 덱의 앞쪽 원소가 윈도우 범위를 벗어나면 제거
		if (dq.front().index <= i - L) {
			dq.pop_front();
		}

		// 덱의 맨 앞에 있는 값이 현재 슬라이딩 윈도우에서의 최솟값
		cout << dq.front().value << " ";
	}

	return 0;
}
