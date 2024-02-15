package Silver.II;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) numArr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        dp[0] = numArr[0];

        for (int i = 1; i < n; i++){
            dp[i] = numArr[i];
            for (int j = 0; j < i; j++){
                if(numArr[i] > numArr[j]) dp[i] = Math.max(dp[j] + numArr[i], dp[i]);
            }
        }

        int maxNum = 0;
        for (int i : dp) maxNum = Math.max(i, maxNum);
        System.out.print(maxNum);
    }
}
