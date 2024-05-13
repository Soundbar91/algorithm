package Gold.V;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ_2212 {
    static int N;
    static int K;
    static int[] coordinate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        coordinate = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        int[] temp = IntStream.range(0, N - 1)
                .map(i -> coordinate[i + 1] - coordinate[i])
                .sorted()
                .toArray();

        return IntStream.range(0, N - (K - 1) - 1)
                .mapToLong(i -> temp[i])
                .sum();
    }
}
