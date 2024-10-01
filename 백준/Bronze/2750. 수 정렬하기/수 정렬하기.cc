#include <iostream>

using namespace std;
void swap(int& a, int& b) {
    int temp = b;
    b = a;
    a = temp;
}
int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int N;
    cin >> N;
    int arr[1001] = { 0, };

    for (int k = 0; k < N; k++) {
        cin >> arr[k];
    }
    
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - 1- i; j++) {
            if (arr[j] > arr[j + 1]) swap(arr[j], arr[j + 1]);
        }
    }

    for (int i = 0; i < N; i++) {
        cout << arr[i] << "\n";
    }

    return 0;
}