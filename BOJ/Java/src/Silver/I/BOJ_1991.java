package Silver.I;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static int N;
    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char parentValue = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            insertNode(head, parentValue, leftValue, rightValue);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
        System.out.println();
    }

    static class Node{
        public char value;
        public Node left;
        public Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void preorder(Node startPoint) {
        if (startPoint != null) {
            System.out.print(startPoint.value);
            preorder(startPoint.left);
            preorder(startPoint.right);
        }
    }

    public static void inorder(Node startPoint) {
        if (startPoint != null) {
            inorder(startPoint.left);
            System.out.print(startPoint.value);
            inorder(startPoint.right);
        }
    }

    public static void postorder(Node startPoint) {
        if (startPoint != null) {
            postorder(startPoint.left);
            postorder(startPoint.right);
            System.out.print(startPoint.value);
        }
    }

    public static void insertNode(Node head, char value, char left, char right) {
        if (head.value == value) {
            head.left = (left == '.' ? null : new Node(left, null, null));
            head.right = (right == '.' ? null : new Node(right, null, null));
        }
        else {
            if (head.left != null) insertNode(head.left, value, left, right);
            if (head.right != null) insertNode(head.right, value, left, right);
        }
    }
}
