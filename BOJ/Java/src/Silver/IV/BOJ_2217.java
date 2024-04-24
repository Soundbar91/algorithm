package Silver.IV;

import java.io.*;
import java.util.Arrays;

public class BOJ_2217 {
    static int N;
    static int[] rope;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rope = br.lines().limit(N).mapToInt(Integer::parseInt).toArray();

        System.out.print(solve());
    }

    public static int solve() {
        Arrays.sort(rope);

        int result = -1;
        for (int i = 0; i < rope.length; i++) {
            result = Math.max(result, rope[i] * (N - i));
        }

        return result;
    }
}
