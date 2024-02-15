package Silver.II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15664 {
    static boolean[] visit;
    static int[] node;
    static int[] num;
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
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0, 0);

        System.out.print(sb);
    }

    public static void dfs(int index, int depth){

        if (depth == M){
            for (int i : node){
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        else{
            int before = 0;

            for (int i = index; i < N; i++){
                if (visit[i]) continue;

                if (before != num[i]){
                    visit[i] = true;
                    node[depth] = num[i];
                    before = num[i];
                    dfs(i, depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
