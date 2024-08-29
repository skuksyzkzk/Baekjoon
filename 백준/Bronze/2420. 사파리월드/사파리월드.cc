#include <iostream>

using namespace std;

int main()
{

    long long a, b;
    cin >> a >> b;
    cout << ((a - b > 0) ? (a - b) : -(a - b));
}