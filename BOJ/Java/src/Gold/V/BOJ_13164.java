package Gold.V;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class BOJ_13164 {
    static int N;
    static int K;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        height = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solve());
    }

    public static int solve() {
        return IntStream.range(0, N - 1)
                .map(i -> height[i + 1] - height[i])
                .sorted()
                .limit(height.length - K)
                .sum();
    }
}
