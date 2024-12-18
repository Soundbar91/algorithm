package Gold.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static int R;
    static int C;
    static int T;
    static int cleanerY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && cleanerY == 0) cleanerY = i;
            }
        }

        while (T-- > 0) {
            map = diffusion();
            clean();
        }

        System.out.print(count() + 2);
        br.close();
    }

    public static int[][] diffusion() {
        int[][] copyMap = new int[50][50];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    copyMap[i][j] = -1;
                    continue;
                }

                copyMap[i][j] += map[i][j];

                for (int k = 0; k < 4; k++) {
                    int ux = j + dx[k];
                    int uy = i + dy[k];

                    if (!valid(ux, uy)) continue;
                    if (map[uy][ux] == -1) continue;

                    copyMap[uy][ux] += (map[i][j] / 5);
                    copyMap[i][j] -= (map[i][j] / 5);
                }
            }
        }

        return copyMap;
    }

    public static void clean() {
        int top = cleanerY;

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }

        map[top][1] = 0;

        int bottom = cleanerY + 1;

        for (int x = bottom + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0;
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && x < C) && (y >= 0 && y < R);
    }

    public static int count() {
        int result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += map[i][j];
            }
        }

        return result;
    }
}
