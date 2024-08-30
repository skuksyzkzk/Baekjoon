#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n, x;
    int input;
    vector<int> v;
    cin >> n >> x;
    for (int i = 0; i < n; i++)
    {
        cin >> input;
        v.push_back(input);
    }
    for (int j = 0; j < n; j++)
    {
        if (v[j] < x)
            cout << v[j] << " ";
    }

    return 0;
}