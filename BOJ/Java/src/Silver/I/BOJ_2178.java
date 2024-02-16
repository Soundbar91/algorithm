package Silver.I;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++){
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++){
                map[i][j] = chars[j] - '0';
            }
        }

        bfs(0, 0);
        System.out.print(map[N - 1][M - 1]);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];

            for (int i = 0; i < 4; i++){
                int ux = nodeX + dx[i];
                int uy = nodeY + dy[i];

                if (valid(ux, uy) && map[uy][ux] == 1 && !visited[uy][ux]){
                    queue.add(new int[] {ux, uy});
                    map[uy][ux] = map[nodeY][nodeX] + 1;        // 가중치 갱신
                    visited[uy][ux] = true;
                }
            }

        }
    }

    public static boolean valid(int x, int y){
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
