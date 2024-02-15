package Gold.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14500 {
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visit;
    static int result;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                visit[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.print(result);
    }

    public static boolean valid(int x, int y){
        if (x >= N || y >= M || x < 0 || y < 0) return false;
        else return true;
    }

    public static void dfs(int x, int y, int sum, int count){
        if (count == 4) {
            result = Math.max(result, sum);
            return ;
        }

        for (int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if(!valid(curX, curY)) continue;

            if(!visit[curX][curY]){

                if(count == 2){
                    visit[curX][curY] = true;
                    dfs(x, y, sum + board[curX][curY], count + 1);
                    visit[curX][curY] = false;
                }

                visit[curX][curY] = true;
                dfs(curX, curY, sum + board[curX][curY], count + 1);
                visit[curX][curY] = false;
            }
        }

    }
}
