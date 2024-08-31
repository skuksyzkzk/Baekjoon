#include <cstdio>
#include <cstring>
char arr[103];
int main()
{
    scanf("%s", arr);
    for (int i = 0; i < strlen(arr); i++)
    {
        if ((int)arr[i] >= 97)
            arr[i] = arr[i] - 32;
        else
            arr[i] = arr[i] + 32;
    }
    printf("%s", arr);
    return 0;
}