#include <iostream>
#include <vector>

using namespace std;
int n, a, x, s;
vector<int> v;
int main()
{
    cin >> n;
    while (n--)
    {
        cin >> a;
        v.push_back(a);
    }
    cin >> x;
    vector<int>::iterator iter;
    for (iter = v.begin(); iter != v.end(); iter++)
    {
        if (*iter == x)
            s++;
    }
    cout << s;
    return 0;
}