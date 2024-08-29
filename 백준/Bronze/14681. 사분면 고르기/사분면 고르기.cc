#include <iostream>

int main() {
    int a,b;scanf("%d %d",&a,&b);
    printf("%d",a>0?(b>0?1:4):(b>0?2:3));
    return 0;
}