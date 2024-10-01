#include <iostream>
#include <string>

using namespace std;
void swap(int& a, int& b) {
    int temp = b;
    b = a;
    a = temp;
}
int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    string str;
    cin >> str;
    int arr[11] = { 0, };
    for (int i = 0; i < str.length(); i++) {
        arr[i] = str[i] - 48;
    }

    // selection sort

    for (int j = 0; j < str.length(); j++) {
        int mx = -1;
        int mx_int = 0;
        // find max
        for (int k = j; k < str.length(); k++) {
            if (arr[k] > mx) {
                mx = arr[k];
                mx_int = k;
    
            }
        }
        int temp = arr[mx_int];
        arr[mx_int] = arr[j];
        arr[j] = temp;
    }
    for (int q = 0; q < str.length(); q++) {
        cout << arr[q];
    }
    return 0;
}