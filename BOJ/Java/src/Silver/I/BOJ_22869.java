package Silver.I;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22869 {
    static int N;
    static int K;
    static int[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stone = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print(solve() ? "YES" : "NO");
        br.close();
    }

    public static boolean solve() {
        boolean[] dp = new boolean[N];
        dp[0] = true;

        for (int i = 0; i < N; i++) {
            if (dp[i]) {
                for (int j = i + 1; j < N; j++) {
                    if ((j - i) * (Math.abs(stone[i] - stone[j]) + 1) <= K) {
                        dp[j] = true;
                    }
                }
            }
        }

        return dp[N - 1];
    }
}
