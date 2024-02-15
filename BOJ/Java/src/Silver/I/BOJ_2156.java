package Silver.I;

import java.io.*;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[10001];

        for(int i = 1; i <= n; i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[10001];
        dp[1] = numArr[1];
        dp[2] = numArr[1] + numArr[2];
        dp[3] = Math.max(dp[2], Math.max(numArr[1] + numArr[3], numArr[2] + numArr[3]));

        for (int i = 4; i <= n; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + numArr[i], dp[i - 3] + numArr[i - 1] + numArr[i]));
        }

        System.out.print(dp[n]);
    }
}
