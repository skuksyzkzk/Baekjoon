#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

int fst[5] = {1,2,3,4,5};
int snd[8] = {2,1,2,3,2,4,2,5};
int trd[10] = {3,3,1,1,2,2,4,4,5,5};
vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int cf = 0; int cs = 0; int ct = 0;
    int fi = 0; int si = 0; int ti = 0;
    for(auto nxt : answers){
        if(fst[fi] == nxt ){
            cf++;
        }
        if(snd[si] == nxt) {
            cs++;
        }
        if(trd[ti] == nxt) {
            ct++;
        }
        fi++;
        fi %= 5;
        si++;
        si %= 8;
        ti++;
        ti %= 10;
    }
    int maxnum = max(cf,max(cs,ct));
    if (maxnum == cf ){
        answer.push_back(1);
    }
    if (maxnum == cs ){
        answer.push_back(2);
    }
    if (maxnum == ct ){
        answer.push_back(3);

    }
    return answer;
}