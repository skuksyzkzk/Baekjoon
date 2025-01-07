import java.util.*;
import java.io.*;

class Solution {
    class Pair {
        int X,Y;
        public Pair(int X,int Y){
            this.X = X;
            this.Y = Y;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        // 0은 벽 1은 벽이 아님 
        int n  = maps.length;
        int m  = maps[0].length;
        
        int [][] dist = new int[n][m];
        // BFS로 최단거리 해결하는 문제 dist로 판단 처음에 dist를 -1로 채우기 
        for (int i = 0; i < n;i++){
            Arrays.fill(dist[i], -1);
        }
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offerLast(new Pair(0,0));
        dist[0][0] = 1;
        
        // 해당 맵을 나가면, 벽이면, 이미 방문 했으면 x 아닐 경우는 갱신하기
        // 막혀있으면 -1 아니면 해당거리 출력
        while (!q.isEmpty()){
            Pair cur = q.poll();
            for (int dir = 0; dir<4;dir++){
                int newX = cur.X + dx[dir];
                int newY = cur.Y + dy[dir];
                if (newX <0 || newX >= n || newY <0 || newY >= m ) continue;
                if (dist[newX][newY] > 0 || maps[newX][newY] == 0) continue;
                
                q.offerLast(new Pair(newX,newY));
                dist[newX][newY] = dist[cur.X][cur.Y] + 1;
            }
        }
        return dist[n-1][m-1] == -1 ? -1 : dist[n-1][m-1];
    }
}