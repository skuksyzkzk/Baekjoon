import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int X,Y;
        int cost;
        public Node(int X,int Y,int cost){
            this.X = X;
            this.Y = Y;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node other){
            return Integer.compare(this.cost,other.cost);
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        
        pq.add(new Node(0,0,0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.X][cur.Y]) continue;
            visited[cur.X][cur.Y] = true;
            answer+= cur.cost;
            
            for (int dir = 0; dir < 4; dir ++) {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx <0 || ny < 0 || nx>= N || ny>=N) continue;
                if (visited[nx][ny]) continue;
                int temp = Math.abs(land[cur.X][cur.Y] - land[nx][ny]);
                int newCost = temp > height ? temp : 0 ;
                pq.add(new Node(nx,ny,newCost));
            }
        }
        
        // height이하이면 비용을 0으로 설정
        return answer;
    }
}