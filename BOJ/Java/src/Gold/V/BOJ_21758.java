package Gold.V;

import java.io.*;
import java.util.Arrays;

public class BOJ_21758 {
    static int N;
    static int[] honey;
    static long result;
    static long[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        honey = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        init();
        moveBee();
        moveHoney();

        return result;
    }

    public static void init() {
        sum = new long[N];

        sum[0] = honey[0];
        for (int i = 1; i < N; i++) sum[i] += honey[i] + sum[i - 1];
    }

    public static void moveBee() {
        for (int i = 1; i < sum.length - 1; i++) {
            long beeA = sum[N - 1] - sum[0] - honey[i];
            long beeB = sum[N - 1] - sum[i];
            result = Math.max(result, beeA + beeB);

            beeA = sum[i - 1];
            beeB = sum[N - 2] - honey[i];
            result = Math.max(result, beeA + beeB);
        }
    }

    public static void moveHoney() {
        for (int i = 1; i < sum.length - 1; i++) {
            long beeA = sum[i] - honey[0];
            long beeB = sum[N - 2] - sum[i - 1];

            result = Math.max(result, beeA + beeB);
        }
    }
}
