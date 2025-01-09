import java.util.*;
class Solution {
    class Point {
        int X, Y, cost, dir;
        public Point(int x, int y, int cost, int dir) {
            this.X = x;
            this.Y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int calCost(int before, int after) {
        if (before == -1) return 100;
        if (before == after) return 100;
        return 600;
    }
    
    public int solution(int[][] board) {
        int N = board.length;
        int[][][] dist = new int[N][N][4];
        for (int[][] d : dist) {
            for (int[] row : d) Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        ArrayDeque<Point> q = new ArrayDeque<>();
        q.offer(new Point(0, 0, 0, -1));
        for (int i = 0; i < 4; i++) dist[0][0][i] = 0;
        
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.X + dx[d];
                int ny = cur.Y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || board[nx][ny] == 1) continue;
                
                int newCost = cur.cost + calCost(cur.dir, d);
                if (dist[nx][ny][d] > newCost) {
                    dist[nx][ny][d] = newCost;
                    q.offer(new Point(nx, ny, newCost, d));
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, dist[N-1][N-1][d]);
        }
        return answer;
    }
}
