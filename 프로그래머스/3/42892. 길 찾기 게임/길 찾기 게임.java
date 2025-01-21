import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int number,X,Y;
        Node left,right;
        
        public Node(int number,int X,int Y,Node left,Node right){
            this.number = number;
            this.X = X;
            this.Y = Y;
            this.left = left;
            this.right = right;
        }
        @Override
        public int compareTo (Node other){
            if (this.Y == other.Y) return Integer.compare(this.X,other.X);
            return Integer.compare(other.Y,this.Y);
        }
    }
    public static Node head;
    public static ArrayList<Integer> preArr;
    public static ArrayList<Integer> postArr;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length+1];
        preArr = new ArrayList<>();
        postArr = new ArrayList<>();
        
        // 우선순위 큐에 insert 
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < nodeinfo.length; i ++) {
            pq.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1],null,null));
        }
        head = pq.poll();
        // 값과 비교해서 작으면 왼쪽 크면 오른쪽 자식이 없을때까지 반복 
        while (!pq.isEmpty()) {
            Node parent = head;
            Node cur = pq.poll();
            while (true) {
                // 부모 보다 작다는 것은 왼쪽 서브트리라는 것 
                if (cur.X < parent.X) {
                    if (parent.left == null) {
                        parent.left = cur;
                        break;
                    } else {
                        parent = parent.left;
                    }
                }
                // 부모 보다 크다는 것은 오른쪽 서브트리라는 것 
                else {
                    if (parent.right == null){
                        parent.right = cur;
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }
        preOrder(head);
        postOrder(head);
        
        answer[0] = preArr.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postArr.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    // 전위
    public void preOrder(Node now){
        if (now == null) return;
        preArr.add(now.number);
        preOrder(now.left);
        preOrder(now.right);
    }
    // 후위
    public void postOrder(Node now){
        if (now == null) return;
        postOrder(now.left);
        postOrder(now.right);
        postArr.add(now.number);
    }
    
}