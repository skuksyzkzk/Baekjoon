import java.util.*;
import java.io.*;

class Main {
	static long[] Tree;
	static int N,M,K;
	static int leafCnt;
	static long[] leafNodes;
	public static void main (String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		leafNodes = new long [N];
		// 리프 노드 저장 
		for (int i = 0 ; i < N ;i++) {
			leafNodes[i] = Long.parseLong(br.readLine());
		}
		InitTree();
		
		for (int i = 0; i < M+K;i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			// a가 1인경우 b를 c로 변경
			if (a==1) {
				update( b,c);
			}
			// a가 2인경우 b부터c까지 합을 구한다.
			else if (a==2) {
				sb.append(makeSum(b,c)+"\n");
			}
			
		}
		System.out.println(sb.toString());	
	}
	// 부분합 
	private static long makeSum(long b, long c) {
		// 왼쪽과 오른쪽 포인터를 설정한다.
		int lt = (int) (b + leafCnt - 1);
		int rt = (int) (c + leafCnt - 1);
		
		// 포인터가 교차할때까지 이동하면서 더한다.
		long sum = 0;
		while (lt <= rt) {
			// 왼쪽  포인터가 오른쪽 자식 일경우
			if (lt % 2 == 1) {
				//System.out.println("lt: "+lt+" "+Tree[lt]);
				sum += Tree[lt];
				lt++;
			}
			// 오른쪽 포인터가 왼쪽 자식 일경우
			if (rt % 2 == 0) {
				//System.out.println("rt: "+rt+" "+Tree[rt]);
				sum += Tree[rt];
				rt--;
			}
			lt/=2;
			rt/=2;
		}
		return sum;
	}
	// 값 변경 b번째를 c로 바꾼다.
	private static void update(long  b, long c) {
		int target = (int) (b+leafCnt-1);
		Tree[target] = c;
		
		int parent = target/2;
		while (parent > 0) {
			Tree[parent] = Tree[parent * 2] + Tree[parent * 2 + 1];
			parent/=2;
		}
	}
	// 트리 init
	private static void InitTree() {
		leafCnt = 1;
		while (leafNodes.length > leafCnt) {
			leafCnt <<=1;
		}
		
		// 트리 구성 (리프 노드 추가)
		Tree = new long[leafCnt*2];
		for (int i = 0; i < leafNodes.length; i++ ) {
			Tree[i+leafCnt] = leafNodes[i]; 
		}
		// 부모 값 갱신 - 합으로 
		for (int i = leafCnt-1;i>=1;i--) {
			Tree[i] = Tree[2*i]+Tree[2*i+1];
		}
			
	}

}