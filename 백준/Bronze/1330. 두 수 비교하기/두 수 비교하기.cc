#include <iostream>

using namespace std;

string prepare(int a,int b){
    if (a>b){
        return ">";
    }else if (a<b){
        return "<";
    }
    return "==";
}

int main() {
    int num1,num2;
    cin >> num1 >> num2 ;
    cout << prepare(num1,num2);
}