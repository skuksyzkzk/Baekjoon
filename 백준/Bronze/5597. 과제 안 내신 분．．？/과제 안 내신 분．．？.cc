#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int arr[31] = {
        -1,
    };
    int n = 28;
    int a;
    while (n--)
    {
        cin >> a;
        arr[a] = -1;
    }
    for (int i = 0; i < 31; i++)
    {
        if (arr[i] != -1)
            cout << i << "\n";
    }
    return 0;
}