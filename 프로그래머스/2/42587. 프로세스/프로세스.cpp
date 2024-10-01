#include <string>
#include <vector>
#include <iostream>
#include <queue>
using namespace std;

struct Process {
    int loc;
    int prio;
    int order;
};
queue<Process> q;
queue<Process> rt;
int solution(vector<int> priorities, int location) {
    int answer = 0;
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    
    
    for (int i = 0; i<priorities.size();i++){
        Process p;
        p.loc  = i;
        p.prio =priorities[i];
        p.order = 0;
        
        q.push(p);
    }
    int od = 1;
    
    for (int j = 0; j<priorities.size();j++){
        int mx = -1;
        // max 값 추출
        for (int k =0; k<q.size();k++){
            if(q.front().prio > mx){
                mx = q.front().prio;
                q.push(q.front());
                q.pop();
            }
            else {
                q.push(q.front());
                q.pop();
            }
        }
        // order 입력 
        for (int l=0; l<q.size();l++){
            if(q.front().prio == mx){
                q.front().order = od++;
                rt.push(q.front());
                q.pop();
                break;
            }
            else {
                q.push(q.front());
                q.pop();
            }
        }
    }
    cout << "RT size: " << rt.size() << "\n";
    int num = rt.size();
    for (int u = 0; u <num; u++){
        cout << "Rt : " << rt.front().loc << ","<<rt.front().prio << "\n";
        if(rt.front().loc == location){
            answer = rt.front().order ;
        } 
        rt.pop();
    }
    return answer;
}