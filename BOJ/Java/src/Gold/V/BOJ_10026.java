package Gold.V;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026 {
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int noBlindness = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(j, i);
                    noBlindness++;
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        int yesBlindness = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    bfs(j, i);
                    yesBlindness++;
                }
            }
        }

        System.out.println(noBlindness + " " + yesBlindness);
        br.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x ,y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ux = point[0] + dx[i];
                int uy = point[1] + dy[i];

                if (!valid(ux, uy) || visited[uy][ux]) continue;

                if (map[point[1]][point[0]] == map[uy][ux]) {
                    visited[uy][ux] = true;
                    queue.add(new int[]{ux, uy});
                }
            }
        }
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

}
