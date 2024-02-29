package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11047 {
    static int N;
    static int K;
    static int cnt;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            cnt += K / coin[i];
            K %= coin[i];
        }

        System.out.print(cnt);
    }
}
