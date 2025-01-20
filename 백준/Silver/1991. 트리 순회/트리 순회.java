import java.util.*;
import java.io.*;

class Main {
	static class Node {
		char value;
		Node left,right;
		public Node (char value,Node left,Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	public static Node head = new Node('A',null,null);
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0 ;  i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			insertNode(head,root,left,right);
		}
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
	}
	public static void insertNode(Node base,char root,char left,char right) {
		if (base.value == root) {
			base.left = (left == '.'?null: new Node(left,null,null));
			base.right = (right == '.'?null: new Node(right,null,null));
		}
		else {
			if (base.left != null) insertNode(base.left, root, left, right);
			if (base.right != null) insertNode(base.right, root, left, right);
		}
	}
	public static void preOrder(Node find) {
		if (find == null) return;
		System.out.print(find.value);
		preOrder(find.left);
		preOrder(find.right);
	}
	public static void inOrder(Node find) {
		if (find == null) return;
		inOrder(find.left);
		System.out.print(find.value);
		inOrder(find.right);
	}
	public static void postOrder(Node find) {
		if (find == null) return;
		postOrder(find.left);
		postOrder(find.right);
		System.out.print(find.value);
	}
}