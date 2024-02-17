package Gold.V;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
    static int M;
    static int N;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        boolean flag = false;       // 저장 될 때부터 모두 익었는지 확인

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                int value = Integer.parseInt(st.nextToken());

                if (value == 0) flag = true;
                if (value == 1) queue.add(new int[]{j, i});     // 익은 토마토
                map[i][j] = value;
            }
        }
        
        // 저장될 때부터 모두 익었으면 출력 후 종료
        if (!flag) {
            System.out.print(0);
            System.exit(0);
        }

        bfs();
    }

    public static void bfs(){
        int day = 0;

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];
            day = map[nodeY][nodeX];

            for (int i = 0; i < 4; i++){
                int ux = nodeX + dx[i];
                int uy = nodeY + dy[i];

                if (valid(ux, uy) && map[uy][ux] == 0){
                    queue.add(new int[]{ux, uy});
                    map[uy][ux] = map[nodeY][nodeX] + 1;
                }
            }
        }

        // 모두 익었는지 확인
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 0) {
                    System.out.print(-1);
                    System.exit(0);
                }
            }
        }

        System.out.print(day - 1);
    }

    public static boolean valid(int x, int y){
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
