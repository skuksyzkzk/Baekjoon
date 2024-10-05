#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

int board[102][102][102];
int dist[102][102][102];

int dx[6] = { 0,0,1,-1,0,0 };
int dy[6] = { 0,0,0,0,1,-1 };
int dz[6] = { 1,-1,0,0,0,0 };

int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int N, M, H;
    cin >> M >> N >> H;
    queue<tuple<int, int, int>> q;
    priority_queue<int> pq;
    bool flag = true;
    for (int k = 0; k < H; k++) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cin >> board[k][i][j];
                if (board[k][i][j] == 1) {
                    q.push(make_tuple(k, i, j));
                }
                else if (board[k][i][j] == 0) {
                    dist[k][i][j] = -1;
                    flag = false;
                }

            }
        }
    }
    if (flag) {
        cout << 0;
        return 0;
    }
    while (!q.empty()) {
        tuple<int, int, int> tp = q.front(); 
        q.pop();
        for (int dir = 0; dir < 6; dir++) {
            int nz = get<0>(tp) + dz[dir];
            int nx = get<1>(tp) + dx[dir];
            int ny = get<2>(tp) + dy[dir];
            if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) continue;
            if (dist[nz][nx][ny] >= 0) continue;
            q.push(make_tuple(nz, nx, ny));
            dist[nz][nx][ny] = dist[get<0>(tp)][get<1>(tp)][get<2>(tp)] + 1;
        }

    }
    for (int k = 0; k < H; k++) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dist[k][i][j] == -1) {
                    cout << -1;
                    return 0;
                }
                pq.push(dist[k][i][j]);

            }
        }
    }

    cout << pq.top();
    return 0;
}