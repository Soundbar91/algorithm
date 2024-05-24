package Gold.III;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
    static final int INF = 987654321;
    static int N;
    static int M;
    static int W;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                Arrays.fill(map[i], INF);
                map[i][i] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                map[S][E] = Math.min(map[S][E], T);
                map[E][S] = map[S][E];
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                map[S][E] = Math.min(map[S][E], -T);
            }

            boolean result = false;
            for (int i = 1; i <= N; i++) {
                if (solve(i)) {
                    result = true;
                    break;
                }
            }

            System.out.println(result ? "YES" : "NO");
        }

        br.close();
    }

    public static boolean solve(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean update = false;
        for (int k = 1; k < N; k++) {
            update = false;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i] != INF && dist[i] + map[i][j] < dist[j]) {
                        dist[j] = dist[i] + map[i][j];
                        update = true;
                    }
                }
            }
            if (!update) break;
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i] != INF && dist[i] + map[i][j] < dist[j])
                        return true;
                }
            }
        }

        return false;
    }
}
