package Silver.II;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            map.get(y).add(x);
        }

        dfs(1);
        for (int i = 2; i <= N; i++) System.out.println(parent[i]);
    }

    public static void dfs(int startPoint) {
        visited[startPoint] = true;

        for (int nextPoint : map.get(startPoint)) {
            if (!visited[nextPoint]) {
                parent[nextPoint] = startPoint;
                dfs(nextPoint);
            }
        }
    }
}
