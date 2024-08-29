#include <iostream>

using namespace std;

int fac(int n)
{
    int result = 1;
    if (n == 0 || n == 1)
    {
    }
    else
    {
        for (int i = 1; i <= n; i++)
        {
            result = result * i;
        }
    }
    return result;
}

int main()
{
    int num1;
    cin >> num1;
    cout << fac(num1);
    return 0;
}