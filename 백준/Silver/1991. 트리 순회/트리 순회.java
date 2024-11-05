
import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        char my;
        Node left,right;

        public Node(char my,Node left,Node right){
            this.my = my;
            this.left = left;
            this.right = right;
        }
    }
    private static Node head = new Node('A',null,null);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0 ; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            insertNode(head,root,left,right);
        }
        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
    }
    public static void insertNode(Node head,char root,char left ,char right){
        if (head.my == root){
            head.left = (left=='.'?null:new Node(left,null,null));
            head.right = (right == '.'?null:new Node(right,null,null));
        }
        else {
            if ( head.left != null){
                insertNode(head.left,root,left,right);
            }
            if (head.right != null){
                insertNode(head.right,root,left,right);
            }
        }

    }

    static void preorder(Node x){
        if (x == null) return;
        System.out.print(x.my);
        preorder(x.left);
        preorder(x.right);
    }
    static void inorder(Node x) {
        if (x == null) return;
        inorder(x.left);
        System.out.print(x.my);
        inorder(x.right);
    }
    static void postorder(Node x){
        if (x == null) return;

        postorder(x.left);
        postorder(x.right);
        System.out.print(x.my);
    }




}