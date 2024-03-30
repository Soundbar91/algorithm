package Gold.IV;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
    static int N;
    static int M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int result = -1;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) queue.add(new int[]{j, i});
            }
        }

        createWall(0);
        System.out.print(result);
        br.close();
    }

    public static void createWall(int depth) {
        if (depth == 3) {
            bfs();
        }
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        createWall(depth + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs() {
        Queue<int[]> copyQ = new LinkedList<>(queue);

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) copyMap[i] = map[i].clone();

        while (!copyQ.isEmpty()) {
            int[] node = copyQ.poll();

            for (int i = 0; i < 4; i++) {
                int ux = node[0] + dx[i];
                int uy = node[1] + dy[i];

                if (!valid(ux, uy) || copyMap[uy][ux] != 0) continue;

                copyMap[uy][ux] = 2;
                copyQ.add(new int[]{ux, uy});
            }
        }

        cnt(copyMap);
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }

    public static void cnt(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }

        result = Math.max(result, cnt);
    }
}
