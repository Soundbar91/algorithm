package Silver.I;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1890 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) break;

                if (i + map[i][j] < N) dp[i + map[i][j]][j] += dp[i][j];
                if (j + map[i][j] < N) dp[i][j + map[i][j]] += dp[i][j];
            }
        }

        return dp[N - 1][N - 1];
    }
}
