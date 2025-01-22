import java.util.*;

class Solution {
    public static int[] parent;
    public boolean union (int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if (aRoot == bRoot ) return false;
        if (parent[aRoot] == parent[bRoot]) {
            parent[aRoot]--;
            parent[bRoot] = aRoot;
        }
        if (parent[aRoot] < parent[bRoot]) {
            parent[bRoot] = aRoot;
        }
        else {
            parent[aRoot] = bRoot;
        }
        
        return true;
        
    }
    public int find (int now) {
        if (parent[now] < 0) return now;
        return parent[now] = find(parent[now]);
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int cnt = 0;
        parent = new int[n];
        Arrays.fill(parent,-1);
        
        ArrayList<int[]> pq = new ArrayList<>();
        for (int i = 0 ; i < costs.length; i++){
            pq.add(costs[i]);
        }
        Collections.sort(pq, (a,b) -> {
             return Integer.compare(a[2],b[2]);
        });
        for (int[] edges : pq){
            if (cnt == n-1 ) return answer;
            if (find(edges[0]) == find(edges[1])) continue;
            else {
                union(edges[0],edges[1]);
                cnt++;
                answer+= edges[2];
            }
            
        }
        return answer;
    }
}