import java.io.*;
import java.util.*;

class Main{
	private static StringBuilder sb;
	// union 둘의 루트 노드의 랭크를 비교
	// 큰 루트 존재시 : 작은 루트의 부모를 큰 루트 노드로 바꾸고,큰 루트노드 랭크 +1
	// 동일 할 시: 아무쪽으로 붙이고 랭크 +1
	private static void union(int[] arr,int[] rank, int a,int b) {
		int aRoot = find(arr,a);
		int bRoot = find(arr,b);
		if (aRoot == bRoot) {
			return;
		}else {
			if (rank[aRoot] >= rank[bRoot]) {
				rank[aRoot]++;
				arr[bRoot] = aRoot;
			}else {
				rank[bRoot]++;
				arr[aRoot] = bRoot ;
			}
		}
		
	}
	// Find : 같은 집합에 포함되어 있는 지 확인하려면 루트 노드가 같은 지 확인 
	private static int find(int[] arr ,int a) {
		while(arr[a] != a) {
			a = arr[a];
		}
		return a;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[] rank = new int[N+1];
		sb = new StringBuilder();
		// 초기 상태는 전부 자기 자신이 루트 
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}
		for (int i= 0; i< M;i++) {
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (mode == 0) {
				union(arr,rank,a,b);
			}else {
				if (find(arr,a) == find(arr,b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
		
	}
}