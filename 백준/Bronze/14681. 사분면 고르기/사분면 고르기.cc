#include <cstdio>
main() {
    int a,b;
    scanf("%d %d",&a,&b);
    printf("%d",((b<0)*2
           )+(a*b<0)+1);
}