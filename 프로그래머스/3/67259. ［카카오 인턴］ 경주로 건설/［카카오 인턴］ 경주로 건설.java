import java.util.*;
// 좌표, 방향, 현재까지 cost 
class Loc {
    int x;
    int y;
    int cost;
    int dir;
    
    public Loc (int x,int y,int cost,int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir ;
    }
}
class Solution {
    private static int N;
    private static int[][][] dist;
    // 방향 
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    // 움직임이 좌표를 벗어나는 지 확인 
    private static boolean isOut(int nx,int ny){
        return (nx < 0 || nx >=N || ny < 0 || ny >= N);
    }
 
    // 방향성에 따른 cost 계산 
    private static int calCost(int prevDir,int currentDir,int cost){
        if ( prevDir == currentDir || Math.abs(prevDir - currentDir) == 2){
            return cost+ 100;
        }
        else return cost + 600;
    }
    public int solution(int[][] board) {
        // 보드의 크기 저장 및 초기화
        N = board.length;
        dist = new int[N+1][N+1][4];
        ArrayDeque<Loc> q = new ArrayDeque<>();
     
        // BFS 수행하면서 이전 방향 정보 바탕으로 갱신 
        q.offer(new Loc(0,0,0,-1));
        while (!q.isEmpty()){
            Loc cur = q.poll();
            
            for (int dir = 0; dir < 4; dir++){
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if(isOut(nx,ny)) continue;
                if (board[nx][ny] != 0 || (nx == 0 && ny == 0)) continue;
                
                int newCost = calCost(cur.dir,dir,cur.cost);
                
                if (dist[nx][ny][dir] ==0 || dist[nx][ny][dir] > newCost){
                    if (cur.x == 0 && cur.y == 0 ){
                        newCost = 100;
                    }
            
                    dist[nx][ny][dir] = newCost;
                    q.offer(new Loc(nx,ny,newCost,dir));
                } 
            }
        }
        int minum = Integer.MAX_VALUE;
        for (int i: dist[N-1][N-1]){
            if (i !=0) minum = Math.min(minum,i);
        }
        return minum;
    }
}