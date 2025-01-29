import java.util.*;

class Solution {
    class Position {
        int x, y, cost;
        public Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] land, int height) {
        int N = land.length;
        int[][] firstVisited = new int[N][N]; // 방문 및 그룹 번호 저장
        int color = 0;
        
        Queue<Position> q = new LinkedList<>();
        List<Position> edges = new ArrayList<>();
        
        // **1️⃣ BFS로 그룹 색칠**
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (firstVisited[i][j] == 0) { // 방문하지 않은 곳이면 BFS 시작
                    color++;
                    q.add(new Position(i, j, land[i][j]));
                    firstVisited[i][j] = color;
                    
                    while (!q.isEmpty()) {
                        Position cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];
                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                            if (firstVisited[nx][ny] > 0) continue; // 이미 방문한 곳
                            
                            if (Math.abs(land[nx][ny] - cur.cost) <= height) { // 이동 가능
                                firstVisited[nx][ny] = color;
                                q.add(new Position(nx, ny, land[nx][ny]));
                            }
                        }
                    }
                }
            }
        }

        // **2️⃣ 그룹 간 최소 비용 사다리 계산**
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    
                    if (firstVisited[i][j] != firstVisited[nx][ny]) { // 다른 그룹 간 연결
                        int cost = Math.abs(land[i][j] - land[nx][ny]);
                        edges.add(new Position(firstVisited[i][j], firstVisited[nx][ny], cost));
                    }
                }
            }
        }

        // **3️⃣ Kruskal 알고리즘 (최소 신장 트리) 적용**
        Collections.sort(edges, Comparator.comparingInt(e -> e.cost)); // 비용 순으로 정렬
        int[] parent = new int[color + 1]; // 그룹 parent 배열
        for (int i = 1; i <= color; i++) parent[i] = i;

        int mstCost = 0, edgeCount = 0;
        for (Position edge : edges) {
            if (union(edge.x, edge.y, parent)) {
                mstCost += edge.cost;
                edgeCount++;
                if (edgeCount == color - 1) break; // MST 완성
            }
        }

        return mstCost;
    }

    private int find(int x, int[] parent) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x], parent);
    }

    private boolean union(int x, int y, int[] parent) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        if (rootX == rootY) return false;
        parent[rootY] = rootX;
        return true;
    }
}
