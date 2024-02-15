package Silver.II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15665 {
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
        node = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth){

        if (depth == M){
            for (int i : node){
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        else{
            int before = 0;

            for (int i = 0; i < N; i++){
                if (before != num[i]){
                    node[depth] = num[i];
                    before = num[i];
                    dfs(depth + 1);
                }
            }
        }
    }
}
