#include <iostream>
using namespace std;
// A＠B = (A+B)×(A-B)
long long alpha(long long a, long long b)
{
    return (a + b) * (a - b);
}
int main()
{
    long long a, b;
    cin >> a >> b;
    cout << alpha(a, b);
    return 0;
}