package Gold.III;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int N;
    static int K;
    static boolean[] visited;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[110001];
        time = new int[110001];

        System.out.print(bfs(N));
    }

    public static int bfs(int startPoint) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPoint, 0});
        int result = Integer.MAX_VALUE;
        visited[startPoint] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int point = node[0];
            int cnt = node[1];

            if (point == K) {
                result = Math.min(result, cnt);
            }

            if (valid(point * 2) && !visited[point * 2]){
                visited[point * 2] = true;
                queue.add(new int[]{point * 2, cnt});
            }
            if (valid(point - 1) && !visited[point - 1]){
                visited[point - 1] = true;
                queue.add(new int[]{point - 1, cnt + 1});
            }
            if (valid(point + 1) && !visited[point + 1]){
                visited[point + 1] = true;
                queue.add(new int[]{point + 1, cnt + 1});
            }
        }

        return result;
    }

    public static boolean valid(int value) {
        return value >= 0 && value <= 110000;
    }
}
