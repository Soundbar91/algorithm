package Gold.V;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static int N;
    static int M;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) graph.add(new ArrayList<>());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i < N; i++) Collections.sort(graph.get(i));

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            dfs(i, 0);
        }
        System.out.print(0);
    }

    public static void dfs(int startPoint, int depth){
        if (depth == 4){
            System.out.print(1);
            System.exit(0);
        }

        else {
            for (int i = 0; i < graph.get(startPoint).size(); i++){
                int nextPoint = graph.get(startPoint).get(i);

                if (!visit[nextPoint]){
                    visit[nextPoint] = true;
                    dfs(nextPoint, depth + 1);
                    visit[nextPoint] = false;
                }
            }
        }
    }
}
