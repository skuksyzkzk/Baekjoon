import java.util.*;

class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int n ;
    static int m;
    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean isOut(int x,int y){
        return (x < 0 || x >= n || y < 0 || y >= m);
    }
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        int[][] dist = new int[n+1][m+1];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        // 초기값 설정 
        for (int[] i : dist) {
            Arrays.fill(i,-1);
        }
        q.offer(new Pair(0,0));
        dist[0][0] = 1;
        
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir ++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(isOut(nx,ny)) continue;
                if(maps[nx][ny] != 1 || dist[nx][ny] > 1) continue;
                dist[nx][ny] = dist[cur.x][cur.y] + 1 ;
                q.offer(new Pair(nx,ny));
            }
        }
        if (dist[n-1][m-1] == -1) return -1;
        else return dist[n-1][m-1];
    }
}