#include <iostream>
using namespace std;
// A＠B = (A+B)×(A-B)
int alpha(int a, int b)
{
    return (a + b) * (a - b);
}
int main()
{
    int a, b;
    cin >> a >> b;
    cout << alpha(a, b);
}