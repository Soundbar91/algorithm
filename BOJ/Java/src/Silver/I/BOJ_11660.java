package Silver.I;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_11660 {
    static int N;
    static int M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dp[i][j] += dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(solve(x1, y1, x2, y2)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static long solve(int x1, int y1, int x2, int y2) {
        return IntStream.rangeClosed(x1, x2)
                .mapToLong(i -> dp[i][y2] - dp[i][y1 - 1])
                .sum();
    }
}
