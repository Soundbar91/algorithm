package Gold.IV;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106 {
    static int C;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 100];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int money = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < C + 100; j++) {
                dp[j] = Math.min(dp[j], dp[j - people] + money);
            }
        }

        int result = 987654321;
        for (int i = C; i < C + 100; i++) result = Math.min(result, dp[i]);

        System.out.print(result);
        br.close();
    }
}
