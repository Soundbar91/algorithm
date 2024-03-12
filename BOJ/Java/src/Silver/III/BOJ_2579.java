package Silver.III;

import java.io.*;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int floor = Integer.parseInt(br.readLine());
        int[] score = new int[floor + 1];
        int[] dp = new int[floor + 1];

        for (int i = 1; i <= floor; i++) score[i] = Integer.parseInt(br.readLine());

        dp[1] = score[1];
        if (floor >= 2) dp[2] = score[1] + score[2];

        for (int i = 3; i <= floor; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        bw.write(String.valueOf(dp[floor]));
        bw.flush();
        bw.close();
        br.close();
    }
}
