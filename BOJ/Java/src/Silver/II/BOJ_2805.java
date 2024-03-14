package Silver.II;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int N;
    static long M;
    static long result;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) tree[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(tree);

        binary_search(0, tree[N - 1]);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void binary_search(long lo, long hi) {
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (fn(mid)) lo = mid;
            else hi = mid;
        }
    }

    public static boolean fn(long param) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (tree[i] - param >= 0) sum += (tree[i]) - param;
        }

        if (sum >= M) {
            result = param;
            return true;
        }
        else return false;
    }
}
