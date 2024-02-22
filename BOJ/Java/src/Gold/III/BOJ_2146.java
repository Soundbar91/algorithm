package Gold.III;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {

    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 2;
    static StringTokenizer st;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = st.nextToken().charAt(0) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] != 0) {
                    visited = new boolean[N][N];
                    bridge(i, j);
                }
            }
        }

        System.out.print(result);
    }

    public static void bfs(int x, int y){
        map[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == 1) bfs(nx, ny);
        }
    }

    public static void bridge(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        int currentIsland = map[x][y];
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];
            int cnt = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = nodeX + dx[i];
                int ny = nodeY + dy[i];

                if ((nx >= 0 && ny >= 0 && nx < N && ny < N)
                        && !visited[nx][ny] && map[nx][ny] != currentIsland){
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) queue.offer(new int[]{nx, ny, cnt + 1});
                    else result = Math.min(result, cnt);
                }

            }
        }
    }
}
