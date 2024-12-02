import java.util.*;

class Solution {
    private static int[] parent;
    // 경로 압축 - find
    private static int find(int x){
        if (parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    // union
    private static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if (aRoot != bRoot){
            parent[aRoot] = bRoot;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int edges = 0;
        // parent 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        // 오름차순 정렬
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2],b[2]));
        // 최소 비용을 선택하는 데 둘의 루트가 다르면 union
        for (int[] edge : costs){
            int aRoot = find(edge[0]);
            int bRoot = find(edge[1]);
            
            if (aRoot != bRoot){
                union(aRoot,bRoot);
                
                edges++;
                answer += edge[2];
            }
        }
        
       
        return answer;
    }
}