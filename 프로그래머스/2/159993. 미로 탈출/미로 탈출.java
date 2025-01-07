import java.util.*;

class Solution {
    class Pair {
        int X,Y;
        public Pair(int x,int y){
            this.X = x;
            this.Y = y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static Pair start,lever,end;
    static char[][] map;
    static int n,m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        for (int i = 0; i<n;i++){
            map[i] = maps[i].toCharArray();
        }
        for (int i = 0; i<n;i++){
            for (int j = 0; j<m;j++){
                if (map[i][j] == 'S'){
                    start = new Pair(i,j);
                }
                else if (map[i][j] == 'E'){
                    end = new Pair(i,j);
                }
                else if (map[i][j] == 'L'){
                    lever = new Pair(i,j);
                }
            }
        }
        
        boolean flag = false;
        int startLever = bfs(start,lever);
        int leverEnd = bfs(lever,end);
        
        if (startLever == -1 || leverEnd == -1) {
            return -1;
        }
        else {
            return startLever + leverEnd;
        }
    }
    public int bfs(Pair s,Pair e){
        int[][] dist = new int[n][m];
        for (int[] i : dist) {
            Arrays.fill(i,-1);
        }
        ArrayDeque<Pair> q = new ArrayDeque<>();
        dist[s.X][s.Y] = 0;
        q.push(new Pair(s.X,s.Y));
        
        while (!q.isEmpty()){
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++){
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx <0 || nx>=n || ny<0 || ny >=m) continue;
                if (map[nx][ny] == 'X' || dist[nx][ny] > 0) continue;
                
                dist[nx][ny] = dist[cur.X][cur.Y] + 1;
                q.offer(new Pair(nx,ny));
                
                if (nx == e.X && ny == e.Y){
                    return dist[nx][ny];
                }
            }
        }
        return -1;
    }
}