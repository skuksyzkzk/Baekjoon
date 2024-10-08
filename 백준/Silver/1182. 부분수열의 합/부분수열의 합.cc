#include <iostream>

using namespace std;

int N, S;
int cnt = 0;
int arr[22];

void c(int level, int sum, int start) {
    // 부분집합이 하나 이상 선택된 경우에만 체크
    if (level > 0 && sum == S) {
        cnt++;
    }
    // start부터 N까지 부분집합을 구성
    for (int i = start; i < N; i++) {
        c(level + 1, sum + arr[i], i + 1);
    }
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N >> S;
    
    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    // 재귀를 통해 모든 부분집합을 탐색
    c(0, 0, 0);
    
    // 출력
    cout << cnt;
    return 0;
}
