import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.println(0);
			return;
		}
		int[] dist = new int[200001];
		Arrays.fill(dist, -1);
		dist[N] = 0 ; dist[K] = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(N);
		while(!q.isEmpty()) {
			int cur = q.poll();
			int first = cur -1;
			int second = cur + 1;
			int third = cur * 2;
			
			if (first == K || second == K || third == K) {
				System.out.println(dist[cur] + 1);
				return ;
			}
			if ( first > 0 && first < 200000 &&dist[first] < 0) {
				dist[first] = dist[cur] + 1;
				q.offer(first);
			}
			if (second > 0&& second < 200000 &&dist[second] < 0 ) {
				dist[second] = dist[cur] + 1;
				q.offer(second);
			}
			if ( third > 0 && third < 200000 &&dist[third] < 0 ) {
				dist[third] = dist[cur] + 1;
				q.offer(third);
			}
			
		}
	}
}