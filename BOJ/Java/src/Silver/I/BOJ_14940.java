package Silver.I;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int n;   // 세로
    static int m;   // 가로
    static int distX;
    static int distY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) {
                    distX = j;
                    distY = i;
                }
                map[i][j] = value;
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j] == 1) System.out.print(-1 + " ");
                else System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{distX, distY, 0});
        map[distY][distX] = 0;
        visit[distY][distX] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];
            int dist = node[2];

            for (int i = 0; i < 4; i++) {
                int ux = nodeX + dx[i];
                int uy = nodeY + dy[i];

                if (ux < 0 || uy < 0 || ux >= m || uy >= n) continue;
                if (map[uy][ux] == 0) continue;

                if (map[uy][ux] == 1 && !visit[uy][ux]) {
                    visit[uy][ux] = true;
                    map[uy][ux] = dist + 1;
                    queue.add(new int[]{ux, uy, map[uy][ux]});
                }
            }
        }
    }
}
