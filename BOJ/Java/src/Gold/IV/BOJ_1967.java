package Gold.IV;

import java.io.*;
import java.util.*;

public class BOJ_1967 {
    static int N;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> map = new ArrayList<>();
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.print(0);
            System.exit(0);
        }

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            map.get(parent).add(new int[]{child, wight});
            map.get(child).add(new int[]{parent, wight});
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i, 0);
        }

        System.out.print(result);
    }

    public static void bfs(int startPoint, int weight) {
        visited[startPoint] = true;

        for (int[] node : map.get(startPoint)) {
            int nextPoint = node[0];
            int lineWight = node[1];

            if (!visited[nextPoint]) {
                result = Math.max(weight + lineWight, result);
                bfs(nextPoint, weight + lineWight);
            }
        }
    }
}
