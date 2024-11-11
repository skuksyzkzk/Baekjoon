import java.util.*;

class Solution {
    private static boolean[] visited;
    private static int count1;
    private static int N;
    private static ArrayList<Integer>[] adj;
    
    private static void dfs(int now) {
        if (!visited[now]) visited[now] = true;
        count1++; // 현재 서브 트리의 노드 개수를 증가
        
        for (int next : adj[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    private static void init() {
        count1 = 0;
        visited = new boolean[N + 1];
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        adj = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // 그래프 초기화
        for (int[] wire : wires) {
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        // 전선을 하나씩 제거하며 서브 트리의 차이를 계산
        for (int[] wire : wires) {
            // 전선 제거
            adj[wire[0]].remove(Integer.valueOf(wire[1]));
            adj[wire[1]].remove(Integer.valueOf(wire[0]));
            
            // 첫 번째 서브 트리의 크기 탐색
            init();
            dfs(wire[0]);
            int nodesInFirstSubtree = count1;
            
            // 두 번째 서브 트리의 노드 수는 전체 노드에서 첫 번째 서브 트리 노드 수를 뺀 값
            int nodesInSecondSubtree = n - nodesInFirstSubtree;
            
            // 두 서브 트리의 노드 수 차이 계산
            answer = Math.min(answer, Math.abs(nodesInFirstSubtree - nodesInSecondSubtree));
            
            // 전선 복구
            adj[wire[0]].add(wire[1]);
            adj[wire[1]].add(wire[0]);
        }
        
        return answer;
    }
}
