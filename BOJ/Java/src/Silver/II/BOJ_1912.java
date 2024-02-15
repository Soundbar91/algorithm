package Silver.II;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = numArr[1];
        int maxDp = numArr[1];

        for (int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i - 1] + numArr[i], numArr[i]);
            maxDp = Math.max(maxDp, dp[i]);
        }
        System.out.print(maxDp);
    }
}
