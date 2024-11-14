
import java.util.*;
import java.io.*;

public class Solution {
	
	static class Virus {
		int x;
		int y;
		int dir;
		int cost;
		
		public Virus(int x,int y,int dir,int cost ) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
	private static int[][][] dist;
	private static int T;
	private static ArrayDeque<Virus> q;
	private static HashSet<String> locset;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int N,M,K;
	
	private static boolean isKill(int x,int y) {
		return ( ( x == 0 ) || (x == N-1) || ( y== 0 ) || ( y== N-1 ));
	}
	
	private static void init() {
		for (int[][] layer : dist) {
            for (int[] row : layer) {
                Arrays.fill(row, 0);
            }
        }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1 ; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			dist = new int[N][N][4];
			locset = new HashSet<>();
			// 큐 초기화
			q = new ArrayDeque<>();
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				q.offer(new Virus(x,y,dir-1,cost));
			}
			// 거리 초기화
			for (int cnt = 0; cnt < M; cnt++) {
				locset.clear();
				init();
				while (!q.isEmpty()) {
					Virus cur = q.poll();
					
					int nx = cur.x + dx[cur.dir];
					int ny = cur.y + dy[cur.dir];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (isKill(nx,ny)) {
						int newCost = cur.cost / 2;
						int newDir = 0;
						if(cur.dir == 0) newDir = 1;
						else if(cur.dir == 1) newDir = 0;
						else if(cur.dir == 2) newDir = 3;
						else if(cur.dir == 3) newDir = 2;
						
						dist[nx][ny][newDir] = newCost;
						locset.add(""+nx+"-"+ny);
						
					}else {
						dist[nx][ny][cur.dir] = cur.cost;
						locset.add(""+nx+"-"+ny);
					}	
				}
				
				// 결산 시작 
				for (String loc : locset) {
				    String[] coords = loc.split("-");
				    int x = Integer.parseInt(coords[0]);
				    int y = Integer.parseInt(coords[1]);

				    int maxnum = 0;
				    int maxdir = 0;
				    int current = 0;
				    int sum = 0;
				    for (int next: dist[x][y]) {
				        if (maxnum < next) {
				            maxnum = next;
				            maxdir = current;
				        }
				        sum += next;
				        current++;
				    }
				    q.offer(new Virus(x, y, maxdir, sum));
				}

			}
			int retSum = 0;
			for (Virus v : q) {
				retSum += v.cost;
			}
			sb.append("#"+i+" "+retSum+"\n");
			
		}
		System.out.println(sb);
	}
}
