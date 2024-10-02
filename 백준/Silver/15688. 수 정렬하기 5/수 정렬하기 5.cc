#include <iostream>

using namespace std;

int arr[2000001]={0,};

int main() {
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    int N,input;
    cin >> N;
    for(int i =0;i<N;i++){
        cin >> input;
        arr[input+1000000]++;
    }
    
    for(int i =0;i<2000001;i++){
        if(arr[i]>0){
            for(int j = 0 ; j<arr[i];j++){
                cout<< i - 1000000<<"\n";
            }
        }
    }
    return 0;
}