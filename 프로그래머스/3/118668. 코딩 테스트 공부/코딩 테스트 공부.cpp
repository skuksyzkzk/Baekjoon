#include <string>
#include <vector>
#include <iostream>

using namespace std;
const int MAX = 0x7fffffff;

int solution(int alp, int cop, vector<vector<int>> problems) {
    int maxalp = 0; int maxcop = 0;
    for(auto& pb : problems){
        maxalp = max(maxalp,pb[0]);
        maxcop = max(maxcop,pb[1]);
    }
    alp = min(alp,maxalp);
    cop = min(cop,maxcop);
    
    vector<vector<int>> DP(maxalp+1,vector<int>(maxcop+1,MAX) );
    DP[alp][cop] = 0 ;
    for (int i = alp;i<=maxalp;i++){
        for (int j = cop; j<=maxcop;j++){
            if (i+1 <= maxalp){
                DP[i+1][j] = min(DP[i+1][j],DP[i][j]+1);
            }
            if (j+1 <= maxcop){
                 DP[i][j+1] = min(DP[i][j+1],DP[i][j]+1);
            }
            for (auto& pb : problems) {
                int alp_req =pb[0]; int cop_req = pb[1];
                int alp_rwd =pb[2]; int cop_rwd = pb[3];
                int cost = pb[4];
                if (alp_req <= i && cop_req <=j){
                    int new_alp = min(maxalp,i+alp_rwd);
                    int new_cop = min(maxcop,j+cop_rwd);
                    DP[new_alp][new_cop] = min(DP[new_alp][new_cop],
                                               DP[i][j]+cost);
                }
            }
        }
    }
    
    return DP[maxalp][maxcop];
}