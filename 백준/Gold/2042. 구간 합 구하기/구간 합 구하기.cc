#include <iostream>
#include <vector>

using namespace std;

long long tree[3000000];
int n, m, k;
int start_idx = 1;

void initTree() {
    for (int i = start_idx - 1; i > 0; i--) {
        tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
}

void update(int b, long long c) {
    int idx = b + start_idx - 1;
    long long diff = c - tree[idx];
    tree[idx] = c;
    while (idx /= 2) {
        tree[idx] += diff;
    }
}

void rangesum(int b, int c) {
    int start = b + start_idx - 1;
    int end = c + start_idx - 1;
    long long sum = 0;
    while (start <= end) {
        if (start % 2 == 1) {
            sum += tree[start++];
        }
        if (end % 2 == 0) {
            sum += tree[end--];
        }
        start /= 2;
        end /= 2;
    }

    cout << sum << "\n";
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m >> k;
    
    // start_idx를 세그먼트 트리에서 리프 노드의 시작 인덱스로 설정
    while (start_idx < n) start_idx *= 2;
    
    for (int i = 0; i < n; i++) {
        cin >> tree[start_idx + i];
    }
    
    initTree();

    int turn = m + k;
    while (turn--) {
        int query;
        cin >> query;
        if (query == 1) {
            int b;
            long long c;
            cin >> b >> c;
            update(b, c);
        }
        else if (query == 2) {
            int b, c;
            cin >> b >> c;
            rangesum(b, c);
        }
    }

    return 0;
}
