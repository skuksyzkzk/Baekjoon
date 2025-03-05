import java.util.*;
import java.io.*;

public class Main {
	static class Edge {
		int cnt,number;
		public Edge (int cnt,int number) {
			this.cnt = cnt;
			this.number = number;
		}
	}
	static int N;
	static int visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int [N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        
        visited[N] = 0;
        ArrayDeque<Edge> q = new ArrayDeque<>();
        q.offer(new Edge(0,N));
        
        while (!q.isEmpty()) {
        	Edge cur = q.poll();
        	if (cur.number < 0) continue;
        	if (cur.number == 1) break;
        	
        	if (cur.number % 3 == 0) {
        		if (visited[cur.number/3] > cur.cnt+1) {
        			q.offer(new Edge(cur.cnt+1, cur.number / 3));
        			visited[cur.number/3] = cur.cnt+1;
        		}
        	}
        	
        	if (cur.number % 2 == 0) {
        		if (visited[cur.number/2] > cur.cnt+1) {
        			q.offer(new Edge(cur.cnt+1,cur.number/2));
        			visited[cur.number/2] = cur.cnt+1;
        		}
        	}
        	
        	q.offer(new Edge(cur.cnt+1,cur.number - 1));
        }
        
        System.out.println(visited[1]);
    }
}