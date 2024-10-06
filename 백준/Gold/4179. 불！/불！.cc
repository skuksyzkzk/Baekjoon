#include <iostream>
#include <queue>

#define X first
#define Y second
using namespace std;

char board[1002][1002];
int dist1[1002][1002];
int dist2[1002][1002];

int dx[4] ={1,-1,0,0};
int dy[4] ={0,0,-1,1};

int main(){
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int R, C;
    cin >> R >> C;
    
    queue<pair<int,int>> jq;
    queue<pair<int,int>> fq;
    
    for (int i =0 ; i<R;i++){
        fill(dist1[i],dist1[i]+C,-1);
        fill(dist2[i],dist2[i]+C,-1);
       
        for (int j = 0;j<C;j++){
            cin >> board[i][j];
            if (board[i][j] == 'J'){
                dist1[i][j] = 0;
                jq.push({i,j});
            }
            else if (board[i][j] == 'F'){
                dist2[i][j] = 0;
                fq.push({i,j});
            }
               
        }
    }
    
    // bfs 불 먼저
    while(!fq.empty()){
        pair<int,int> cur = fq.front(); fq.pop();
        for (int dir= 0;dir<4;dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx <0||ny <0||nx>=R||ny>=C) continue;
            if(dist2[nx][ny]>=0||board[nx][ny] == '#') continue;
            fq.push({nx,ny});
            dist2[nx][ny] = dist2[cur.X][cur.Y]+1;
        }
    
    }
    // 지훈이 
    while(!jq.empty()){
        pair<int,int> cur = jq.front(); jq.pop();
        for (int dir= 0;dir<4;dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx <0||ny <0||nx>=R||ny>=C){
                cout << dist1[cur.X][cur.Y]+1;
                return 0;
            }
            if(dist1[nx][ny]>=0||board[nx][ny] == '#') continue;
            if(dist2[nx][ny]!=-1&&dist2[nx][ny] <= dist1[cur.X][cur.Y]+1 )continue;
            jq.push({nx,ny});
            dist1[nx][ny] = dist1[cur.X][cur.Y]+1;
        }
    
    }
    cout<<"IMPOSSIBLE";
    return 0;
}