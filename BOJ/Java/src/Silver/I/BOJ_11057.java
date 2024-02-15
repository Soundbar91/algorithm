package Silver.I;

import java.io.*;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i<= 9; i++){
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++){
            for (int j = 0; j <= 9; j++){
                for (int k = j; k <= 9; k++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }

        long result = 0;
        for (int i : dp[n]){
            result += i;
        }
        System.out.print(result % 10007);
    }
}
