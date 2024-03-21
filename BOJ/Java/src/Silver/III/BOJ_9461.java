package Silver.III;

import java.io.*;

public class BOJ_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] dp;

        while (T-- > 0) {
            int Pn = Integer.parseInt(br.readLine());
            dp = new long[101];

            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;

            for (int i = 4; i <= Pn; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }

            sb.append(dp[Pn]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
