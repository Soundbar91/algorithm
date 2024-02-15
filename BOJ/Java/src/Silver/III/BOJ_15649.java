package Silver.III;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static boolean[] visit;
    static int[] node;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        node = new int[M];

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth){

        if (depth == M){
            for (int i : node){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                node[depth] = i + 1;
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }
}
