package Gold.III;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1005 {
    static int N;
    static int K;
    static int W;
    static int[] edgeCount;
    static int[] time;
    static int[] result;
    static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            edgeCount = new int[N + 1];
            time = new int[N + 1];
            result = new int[N + 1];

            map = new ArrayList<>();
            for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) time[i] = Integer.parseInt(st.nextToken());

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map.get(x).add(y);
                map.get(y).add(x);
                edgeCount[y]++;
            }
            W = Integer.parseInt(br.readLine());

            solve();
        }

        br.close();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (edgeCount[i] == 0) {
                queue.add(i);
                result[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == W) {
                System.out.println(result[W]);
                break;
            }

            for (int i : map.get(cur)) {
                edgeCount[i]--;
                result[i] = Math.max(result[i], result[cur] + time[i]);
                if (edgeCount[i] == 0) queue.add(i);
            }
        }
    }
}
