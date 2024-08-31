#include <cstdio>
#include <cstring>
char arr[1000];
int main()
{
    int n;
    scanf("%s", arr);
    scanf("%d", &n);
    printf("%c", arr[n - 1]);
    return 0;
}