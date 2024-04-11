package Gold.III;

import java.io.*;
import java.util.*;

public class BOJ_2623 {
    static int N;
    static int M;
    static int[] result;
    static int[] edgeCount;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N];
        edgeCount = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for (int i = 1; i < cnt; i++) {
                int cur = Integer.parseInt(st.nextToken());
                map.get(prev).add(cur);
                edgeCount[cur]++;
                prev = cur;
            }
        }

        solve();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (edgeCount[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            for (int i : map.get(cur)) {
                edgeCount[i]--;
                if (edgeCount[i] == 0) queue.add(i);
            }
        }

        if (result.size() != N) System.out.print(0);
        else for (int i : result) System.out.println(i);
    }
}
