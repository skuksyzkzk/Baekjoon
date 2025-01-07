import java.util.*;

class Solution {
    class Pair {
        int X,Y;
        public Pair (int X,int Y){
            this.X = X;
            this.Y = Y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(String[] maps) {
        int answer = 0;
        boolean lever = false;
        int n = maps.length;
        int m = maps[0].length();
        Pair start = null;
        Pair exit = null;
        int[][] dist = new int[n][m];
        for(int[] i : dist){
            Arrays.fill(i,-1);
        }
        // 변환 시키자 int값들로 이루어진 배열로 일단 
        char[][] map = new char[n][m];
        for (int i= 0; i<n;i++){
            map[i] = maps[i].toCharArray();
        }
        for (int i = 0 ; i < n;i++){
            for (int j = 0 ; j< m; j++){
                if (map[i][j] == 'S'){
                    start = new Pair(i,j);
                }
                else if (map[i][j] == 'E'){
                    exit = new Pair(i,j);
                }
            }
        }
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(start.X,start.Y));
        dist[start.X][start.Y] = 0;
        // 일단 동서남북으로 움직임 일단 첫번째 목표는 레버까지 가는 것 
        // 레버를 가면 거기서 레버까지 dist 제외 초기화 
        // 다시 시작해서 EXIT까지 측정 
        // 레버를 댕겨야 됨 , 출구도 찍혀있어야된다. 
        while (!q.isEmpty()){
            Pair cur = q.poll();
            
            for (int dir = 0; dir < 4; dir++){
                int newX = cur.X + dx[dir];
                int newY = cur.Y + dy[dir];
                if (newX < 0 || newX >= n || newY < 0 || newY >=m) continue;
                if (map[newX][newY] == 'X' || dist[newX][newY] > 0) continue;
                dist[newX][newY] = dist[cur.X][cur.Y] + 1;
                if (map[newX][newY] == 'L' && !lever){
                    lever = true;
                    int temp = dist[newX][newY];
                    for (int[] es : dist){
                        Arrays.fill(es,-1);
                    }
                    q.clear();
                    q.push(new Pair(newX,newY));
                    dist[newX][newY] = temp;
                    break;
                }
                q.offer(new Pair(newX,newY));
            }
        }
        if (lever && dist[exit.X][exit.Y] != -1){
            return dist[exit.X][exit.Y];
        }else {
            return -1;
        }
    }
}