#include <stdio.h>
#include <string.h>

int main()
{
    int T;
    scanf("%d", &T);  // 테스트 케이스의 개수를 입력받음
    char s[1001];  // 문자열의 최대 길이는 1000이므로, 배열 크기는 1001로 설정

    for (int i = 0; i < T; i++)
    {
        scanf("%s", s);  // 문자열을 입력받음
        printf("%c%c\n", s[0], s[strlen(s) - 1]);  // 첫 글자와 마지막 글자를 출력
    }

    return 0;
}
