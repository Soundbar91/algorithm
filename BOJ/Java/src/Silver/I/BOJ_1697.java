package Silver.I;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int N;
    static int K;
    static boolean[] visited = new boolean[100001];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);

        System.out.print(result);
    }

    public static void bfs(int startPoint){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPoint, 0});
        visited[startPoint] = true;

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int nextPoint = point[0];
            int cnt = point[1];

            if (nextPoint == K){
                result = Math.min(result, cnt);
            }

            if (valid(nextPoint + 1) && !visited[nextPoint + 1]){
                visited[nextPoint + 1] = true;
                queue.add(new int[]{nextPoint + 1, cnt + 1});
            }
            if (valid(nextPoint - 1) && !visited[nextPoint - 1]){
                visited[nextPoint - 1] = true;
                queue.add(new int[]{nextPoint - 1, cnt + 1});
            }
            if (valid(nextPoint * 2) && !visited[nextPoint * 2]){
                visited[nextPoint * 2] = true;
                queue.add(new int[]{nextPoint * 2, cnt + 1});
            }
        }
    }

    public static boolean valid(int point){
        return point >= 0 && point <= 100000;
    }
}
