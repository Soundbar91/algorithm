package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++){
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        while(n-- > 0){
            int num = Integer.parseInt(br.readLine());
            sb.append(String.valueOf(dp[num])).append("\n");
        }
        System.out.print(sb);
    }
}
