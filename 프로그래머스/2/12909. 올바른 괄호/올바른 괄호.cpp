#include <string>
#include <iostream>
#include <stack>
using namespace std;

bool solution(string s)
{
   ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    stack<char> st;
    cout << s << "\n";
    for (int i =0; i<s.length();i++) {
        
        if (s[i] == ')' && !st.empty()) {
            st.pop();
        }
        else if (s[i] == ')' && st.empty()) {
            return false;
        }
        else if (s[i] == '('){
            st.push('(');
        }
    }
    
    if (st.empty()) return true;
    return false;
}