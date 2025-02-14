import java.io.*;
import java.util.*;

public class Main {
    // 최대 맛 번호
    static final int MAX_TASTE = 1000000;
    // 세그먼트 트리의 리프 노드 개수 (최소 1,000,000 이상의 2의 거듭제곱)
    static int leafCount;
    // 세그먼트 트리 배열
    static int[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        // 세그먼트 트리 초기화: leafCount는 MAX_TASTE 이상의 2의 거듭제곱
        leafCount = 1;
        while (leafCount < MAX_TASTE) {
            leafCount *= 2;
        }
        tree = new int[leafCount * 2];
        // 초기 사탕상자는 비어 있으므로 tree 배열은 모두 0
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) {
                // 1 k : k번째 사탕의 맛 번호를 찾고, 그 사탕을 제거
                int k = Integer.parseInt(st.nextToken());
                int taste = query(k);  // kth 사탕이 있는 맛 번호 구하기
                sb.append(taste).append("\n");
                update(taste, -1);  // 해당 맛 번호의 사탕 개수를 1 감소 (제거)
            } else {
                // 2 B C : 맛 번호 B인 사탕을 C개 추가(또는 제거, C가 음수)
                int taste = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                update(taste, count);
            }
        }
        System.out.print(sb);
    }
    
    // update 함수: 맛 번호 taste의 사탕 개수를 delta만큼 변경 (delta는 음수일 수도 있음)
    static void update(int taste, int delta) {
        // 맛 번호는 1~MAX_TASTE이므로, 0-indexed 리프 노드 인덱스로 변환
        int index = taste - 1 + leafCount;
        tree[index] += delta;
        
        // 부모 노드들도 갱신: index를 2로 나누어 올라가며 갱신
        index /= 2;
        while (index >= 1) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
            index /= 2;
        }
    }
    
    // query 함수: k번째 사탕의 맛 번호를 찾는다.
    // 세그먼트 트리의 루트에서 시작해, 왼쪽 자식의 구간합과 비교하면서 내려간다.
    static int query(int k) {
        int index = 1; // 루트 인덱스
        // 리프 노드에 도달할 때까지 반복
        while (index < leafCount) {
            // 왼쪽 자식 인덱스: index * 2, 오른쪽 자식 인덱스: index * 2 + 1
            if (tree[index * 2] >= k) {
                // 왼쪽 구간에 k번째 사탕이 있다면 왼쪽으로 내려간다.
                index = index * 2;
            } else {
                // 왼쪽 구간의 사탕 수보다 작다면, 오른쪽 구간으로 이동하기 전에
                // k에서 왼쪽 구간의 개수를 빼준다.
                k -= tree[index * 2];
                index = index * 2 + 1;
            }
        }
        // index가 leafCount 이상이면 리프 노드에 도달한 것.
        // 리프 노드의 인덱스에서 taste 번호는 (index - leafCount + 1)
        return index - leafCount + 1;
    }
}
