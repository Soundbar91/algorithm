package Silver.II;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4963 {

    static int w;
    static int h;
    static int cnt;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] map;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;
            map = new int[h][w];
            cnt = 0;

            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (map[i][j] == 1) {
                        map[i][j] = 0;
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            result.add(cnt);
        }

        for (int i : result) System.out.println(i);
    }

    public static void bfs(int y, int x){
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(x, y));

        while (!stack.empty()){
            Node node = stack.pop();
            int nodeX = node.getX();
            int nodeY = node.getY();

            // 상하좌우 + 대각선 탐색
            for (int i = 0; i < 8; i++){
                int nx = nodeX + dx[i];
                int ny = nodeY + dy[i];

                if (valid(nx, ny) && map[ny][nx] == 1){
                    map[ny][nx] = 0;
                    stack.push(new Node(nx, ny));
                }
            }
        }
    }

    // 좌표가 맵 좌표 범위에 있는지 검사하는 함수
    public static boolean valid(int x, int y){
        return (x >= 0 && x < w) && (y >= 0 && y < h);
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
