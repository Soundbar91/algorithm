package Gold.V;

import java.io.*;
import java.util.*;

public class BOJ_2294 {
    static final int INF = 987654321;
    static int n;
    static int k;
    static TreeSet<Integer> coins = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) coins.add(Integer.parseInt(br.readLine()));

        int result = solve();
        System.out.print(result != INF ? result : -1);
        br.close();
    }

    public static int solve() {
        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                if (i - coin >= 0) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[k];
    }
}
