import java.util.*;
class Pair {
    int x, y;
    public Pair(int x,int y){
        this.x = x ;
        this.y = y ; 
    }
}
class Solution {
    private static int n,m;
    private static int[][] dist;
    private static final int[] dx = {1,-1,0,0};
    private static final int[] dy = {0,0,1,-1};

    private static Pair start,end;
    
    private static void initDist(){
        for(int[] i : dist){
            Arrays.fill(i,-1);
        }
    }
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        // char[][] 
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++){
            map[i] = maps[i].toCharArray();
        }
        // start,end 저장 
        for (int i = 0; i<n;i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 'S')
                    start = new Pair(i,j);
                if (map[i][j] == 'E')
                    end = new Pair(i,j);
            }
        }
        // dist, queue 초기화 
        dist = new int[n][m];
        initDist();
        dist[start.x][start.y] = 0;
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(start.x,start.y));
        boolean flag = false;
        // Lever 만날때까지 일단 BFS 진행 
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || nx >= n|| ny < 0 || ny >=m) continue;
                if (map[nx][ny] == 'X'||dist[nx][ny] > 0) continue;
                
                dist[nx][ny] = dist[cur.x][cur.y] + 1 ;
                if (map[nx][ny] == 'L'){
                    q.clear();
                    int lever = dist[nx][ny];
                    initDist();
                    dist[nx][ny] = lever;
                    q.offer(new Pair(nx,ny));
                    flag = true;
                    break;
                }
                q.offer(new Pair(nx,ny));
            }
        }
        if (flag) return dist[end.x][end.y] == -1 ? -1 : dist[end.x][end.y];
        else return -1;
        
        
    }
}