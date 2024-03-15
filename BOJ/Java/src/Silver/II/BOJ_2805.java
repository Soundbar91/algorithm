package Silver.II;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int N;
    static long M;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[N];

        st = new StringTokenizer(br.readLine());
        long min = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) max = tree[i];
        }

        while (min < max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (long i : tree) {
                if (i - mid > 0) sum += (i - mid);
            }

            if (sum < M) max = mid;
            else min = mid + 1;
        }

        bw.write(String.valueOf(min - 1));
        bw.flush();
        bw.close();
        br.close();
    }
}
