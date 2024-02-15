package Silver.I;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BOJ_2667 {

    static int N;
    static int[][] map;
    static int cnt;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] == 1){
                    cnt = 0;
                    bfs(i, j);
                }
            }
        }

        System.out.println(result.size());

        Collections.sort(result);
        for (int i : result){
            System.out.println(i);
        }
    }

    public static void bfs(int x, int y){
        Stack<Node> stack = new Stack<>();
        pushStack(x, y, stack);

        while (!stack.empty()){
            Node node = stack.pop();
            int nodeX = node.getX();
            int nodeY = node.getY();

            // 좌우하상 순서로 검사
            if (valid(nodeX - 1, nodeY) && map[nodeX - 1][nodeY] == 1) pushStack(nodeX - 1, nodeY, stack);
            if (valid(nodeX + 1, nodeY) && map[nodeX + 1][nodeY] == 1) pushStack(nodeX + 1, nodeY, stack);
            if (valid(nodeX, nodeY + 1) && map[nodeX][nodeY + 1] == 1) pushStack(nodeX, nodeY + 1, stack);
            if (valid(nodeX, nodeY - 1) && map[nodeX][nodeY - 1] == 1) pushStack(nodeX, nodeY - 1, stack);
        }

        result.add(cnt);
    }

    // 좌표가 맵 좌표 범위에 있는지 검사하는 함수
    public static boolean valid(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    // 스택에 정점의 좌표를 넣고 방문 표시를 하는 함수
    public static void pushStack(int x, int y, Stack<Node> stack){
        stack.push(new Node(x, y));
        map[x][y] = 0;
        cnt++;
    }

    // 정점의 좌표를 관리하는 클래스
    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
