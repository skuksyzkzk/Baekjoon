#include <iostream>
#include <string>
using namespace std;

int arr[10];
int a,b,c;
int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> a >> b >> c;
    long long sum = a * b * c ;
    string str = to_string(sum);
    
    for (int i = 0;i<str.length(); i++){
        arr[str[i] - '0']++;
    }
    
    for (int i = 0;i<10;i++)
        cout << arr[i] << "\n";
    return 0;
}