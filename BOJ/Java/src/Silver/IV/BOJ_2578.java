package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2578 {
    static int result;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());
                result++;
                markNumber(call);
                if (isBingo()) {
                    System.out.print(result);
                    br.close();
                    return;
                }
            }
        }
    }

    public static void markNumber(int call) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == call) {
                    visited[i][j] = true;
                    return;
                }
            }
        }
    }

    public static boolean isBingo() {
        int count = 0;

        for (int i = 0; i < 5; i++) if (isRowBingo(i)) count++;
        for (int i = 0; i < 5; i++) if (isColumnBingo(i)) count++;

        if (isLeftDiagonalBingo()) count++;
        if (isRightDiagonalBingo()) count++;

        return count >= 3;
    }

    public static boolean isRowBingo(int row) {
        for (int j = 0; j < 5; j++) {
            if (!visited[row][j]) return false;
        }
        return true;
    }

    public static boolean isColumnBingo(int col) {
        for (int i = 0; i < 5; i++) {
            if (!visited[i][col]) return false;
        }
        return true;
    }

    public static boolean isLeftDiagonalBingo() {
        for (int i = 0; i < 5; i++) {
            if (!visited[i][i]) return false;
        }
        return true;
    }

    public static boolean isRightDiagonalBingo() {
        for (int i = 0; i < 5; i++) {
            if (!visited[i][4 - i]) return false;
        }
        return true;
    }
}
