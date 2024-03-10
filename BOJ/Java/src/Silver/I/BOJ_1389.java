package Silver.I;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N;   // 유저 수
    static int M;   // 간선 수
    static int[] result;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());
        result = new int[2];
        result[0] = Integer.MAX_VALUE;  // 노드 번호
        result[1] = Integer.MAX_VALUE;  // 케빈 베이컨

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (map.get(x).contains(y)) continue;
            map.get(x).add(y);
            map.get(y).add(x);
        }

        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1];
            visited = new boolean[N + 1];
            bfs(i);
        }

        bw.write(String.valueOf(result[0]));
        bw.flush();
    }

    public static void bfs(int startPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);
        visited[startPoint] = true;
        dist[startPoint] = 0;
        int sum = 0;

        while(!queue.isEmpty()) {
            int point = queue.poll();
            sum += dist[point];

            for (int nextPoint : map.get(point)) {
                if (!visited[nextPoint]) {
                    dist[nextPoint] = dist[point] + 1;
                    visited[nextPoint] = true;
                    queue.add(nextPoint);
                }
            }
        }

        if (result[1] == sum) {
            result[0] = Math.min(result[0], startPoint);
        }
        else if (result[1] > sum){
            result[0] = startPoint;
            result[1] = sum;
        }
    }
}
