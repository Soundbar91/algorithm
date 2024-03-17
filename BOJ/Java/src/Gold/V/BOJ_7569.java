package Gold.V;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
    static int M;
    static int N;
    static int H;
    static int cnt;
    static int result;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] tomato;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());

                    if (tomato[i][j][k] == 1) queue.add(new int[]{k, j, i});
                    else if (tomato[i][j][k] == 0) cnt++;
                }
            }
        }

        bfs();

        if (cnt == 0) System.out.print(result);
        else System.out.print(-1);

        br.close();
    }

    public static void bfs() {
        while (cnt > 0 && !queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] node = queue.poll();

                for (int j = 0; j < 6; j++) {
                    int ux = node[0] + dx[j];
                    int uy = node[1] + dy[j];
                    int uz = node[2] + dz[j];

                    if (!valid(ux, uy, uz)) continue;
                    if (tomato[uz][uy][ux] != 0) continue;

                    cnt--;
                    queue.add(new int[]{ux, uy, uz});
                    tomato[uz][uy][ux] = 1;
                }
            }
            result++;
        }
    }

    public static boolean valid(int x, int y, int z) {
        return (x >= 0 && x < M) && (y >= 0 && y < N) && (z >= 0 && z < H);
    }
}
