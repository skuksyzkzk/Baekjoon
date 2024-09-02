#include <iostream>

using namespace std;

int main()
{
    char *p = NULL;
    int num;
    int sum = 0;

    cin >> num;
    p = new char[num + 1];
    cin >> p;

    for (int i = 0; i < num; i++)
    {
        sum += p[i] - '0';
    }
    cout << sum;
}