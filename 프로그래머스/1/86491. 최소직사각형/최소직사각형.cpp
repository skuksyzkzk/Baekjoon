#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

#define X first
#define Y second

using namespace std;
vector<pair<int,int>> able;

int solution(vector<vector<int>> sizes) {
    int maxwidth = 0;
    int maxheight = 0;
    
    for (int i = 0 ;i<sizes.size();i++){
        if (sizes[i][0] < sizes[i][1]){
            able.push_back({sizes[i][1],sizes[i][0]});
        }
        else {
            able.push_back({sizes[i][0],sizes[i][1]});
        }
    }
    
    for (int i = 0;i<sizes.size();i++){
        maxwidth = max(maxwidth,able[i].first);
        maxheight = max(maxheight,able[i].second);
    }
   

    return  maxwidth * maxheight;
}