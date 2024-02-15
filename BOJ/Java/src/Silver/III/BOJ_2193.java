package Silver.III;

import java.io.*;

public class BOJ_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[91][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 90; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }

        int n = Integer.parseInt(br.readLine());

        long result = 0;
        for (long i : dp[n]) {
            result += i;
        }
        System.out.print(result);

    }
}
