package Silver.I;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static int R;
    static int C;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) Arrays.fill(map[i], -1);

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if (ch == 'O') map[i][j] = 0;
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        int time = 1;

        while (++time <= N) {
            if (time % 2 == 0) plantingBomb(time);
            else explosionBomb(time);
        }

        printResult();
    }

    public static void plantingBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) map[i][j] = time;
            }
        }
    }

    public static void explosionBomb(int time) {
        int standard = time - 3;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == standard) {
                    map[i][j] = -1;

                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (!valid(x, y)) continue;
                        if (map[x][y] == standard) continue;
                        map[x][y] = -1;
                    }
                }
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void printResult() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) System.out.print('.');
                else System.out.print('O');
            }
            System.out.println();
        }
    }
}
