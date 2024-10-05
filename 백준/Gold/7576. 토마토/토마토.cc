#include <iostream>
#include <queue>
#include <algorithm>

#define X first
#define Y second

using namespace std;
int board[1002][1002];
int dist[1002][1002];

int dx[4] = { 1,-1,0,0 };
int dy[4] = { 0,0,1,-1 };
int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int M, N;
    cin >> M >> N;
    bool flag = true;
    queue<pair<int, int>> q;
    priority_queue<int> pq;
    // dist와 board 초기화
    for (int i = 0; i < N; i++) {
        //-2가 방문안한 것
        fill(dist[i], dist[i] + M, -2);
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
            if (board[i][j] == 1) {
                dist[i][j] = 0;
                q.push({ i,j });
            }
            else if (board[i][j] == -1) dist[i][j] = -1;
            else flag = false;
        }

    }
    // 이미 익었다면
    if (flag) {
        cout << 0;
        return 0;
    }
    // bfs시작
    while (!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (dist[nx][ny] != -2 || board[nx][ny] != 0) continue;
            q.push({ nx,ny });
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
        }
    }
    // 토마토가 모두 익지 못하는 상황
    for (int k = 0; k < N; k++) {
        for (int l = 0; l < M; l++) {
            if (dist[k][l] == -2) {
                cout << -1;
                return 0;
            }
            pq.push(dist[k][l]);
        }
    }
    // 출력
    cout << pq.top();



    return 0;
}