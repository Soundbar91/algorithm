package Gold.II;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2250 {
    static int N;
    static int treeWidth = 1;
    static int resultWidth = -1;
    static int resultLevel = 10003;
    static LinkedList<LinkedList<Integer>> map = new LinkedList<>();
    static class Node {
        public int value;
        public int left;
        public int right;

        public Node(int value, int left, int right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static int[] parent;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parentValue = Integer.parseInt(st.nextToken());
            int leftValue = Integer.parseInt(st.nextToken());
            int rightValue = Integer.parseInt(st.nextToken());

            if (leftValue != -1) parent[leftValue] = parentValue;
            if (rightValue != -1) parent[rightValue] = parentValue;
            tree[parentValue] = new Node(parentValue, leftValue, rightValue);
        }

        for (int i = 0; i <= N; i++) map.add(new LinkedList<>());

        int rootIndex = N;
        while (parent[rootIndex] != 0) rootIndex = parent[rootIndex];

        inorder(tree[rootIndex].value, 1);

        for (int i = 1; i <= N; i++){
            if (map.get(i).isEmpty()) break;
            int value = Math.abs(map.get(i).getLast() - map.get(i).getFirst()) + 1;

            if (value == resultWidth) {
                resultLevel = Math.min(resultLevel, i);
            }
            else if (value > resultWidth) {
                resultWidth = value;
                resultLevel = i;
            }
        }

        System.out.print(resultLevel + " " + resultWidth);
    }

    public static void inorder(int startPoint, int level) {
        if (startPoint != -1) {
            inorder(tree[startPoint].left, level + 1);
            map.get(level).add(treeWidth++);
            inorder(tree[startPoint].right, level + 1);
        }
    }
}
