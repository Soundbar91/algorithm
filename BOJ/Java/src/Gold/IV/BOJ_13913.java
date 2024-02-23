package Gold.IV;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913 {
    static int N;
    static int K;
    static int[] parent = new int[100001];
    static int result = Integer.MAX_VALUE;
    static ArrayList<Integer> route = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 100000; i++) parent[i] = -1;
        result = bfs(N);

        System.out.println(result);

        for (int i = 0; i <= result; i++){
            route.add(K);
            K = parent[K];
        }

        for (int i = route.size() - 1; i >= 0; i--) System.out.print(route.get(i) + " ");
    }

    public static int bfs(int startPoint){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPoint, 0});
        parent[startPoint] = 0;

        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int nextPoint = point[0];
            int cnt = point[1];

            if (nextPoint == K) return cnt;

            if (valid(nextPoint + 1) && parent[nextPoint + 1] == -1){
                parent[nextPoint + 1] = nextPoint;
                queue.add(new int[]{nextPoint + 1, cnt + 1});
            }
            if (valid(nextPoint - 1) && parent[nextPoint - 1] == -1){
                parent[nextPoint - 1] = nextPoint;
                queue.add(new int[]{nextPoint - 1, cnt + 1});
            }
            if (valid(nextPoint * 2) && parent[nextPoint * 2] == -1){
                parent[nextPoint * 2] = nextPoint;
                queue.add(new int[]{nextPoint * 2, cnt + 1});
            }
        }

        return 0;
    }

    public static boolean valid(int point){
        return point >= 0 && point <= 100000;
    }
}
