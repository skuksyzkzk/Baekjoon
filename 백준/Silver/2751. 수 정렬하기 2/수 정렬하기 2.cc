#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios::sync_with_stdio(0); cin.tie(0);
    int N;
    cin >> N;
    vector<int> v(N,0);
    
    for (int i = 0; i<N;i++){
        cin >> v[i];
    }
    
    sort(v.begin(),v.end());
    for (auto z: v){
        cout << z << "\n";
    }
    return 0;
}