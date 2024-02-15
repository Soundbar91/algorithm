package Silver.III;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501 {
    static int N;
    static int[] Ti;
    static int[] Pi;
    static boolean[] visit;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Ti = new int[N];
        Pi = new int[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            dfs(i, 0);
        }

        System.out.print(result);
    }
    
    // start : 현재 날짜
    public static void dfs(int start, int sum){
        if (start == N){
            result = Math.max(result, sum);
        }

        else {
            for (int i = start; i < N; i++){
                if (!visit[i]){
                    if (i + Ti[i] > N) {
                        result = Math.max(result, sum);
                        continue;
                    }

                    visit[i] = true;
                    sum += Pi[i];
                    dfs(i + Ti[i], sum);
                    sum -= Pi[i];
                    visit[i] = false;
                }
            }
        }
    }
}
