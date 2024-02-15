package Silver.I;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] numArr = new int[n][n];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++){
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = numArr[0][0];

        for (int i = 1; i < n; i++){
            for (int j = 0; j < n; j++){
                if (j == 0) dp[i][j] = dp[i - 1][j] + numArr[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + numArr[i][j];
            }
        }

        int maxNum = 0;
        for (int i = 0; i < n; i++){
            maxNum = Math.max(maxNum, dp[n - 1][i]);
        }
        System.out.print(maxNum);
    }
}
