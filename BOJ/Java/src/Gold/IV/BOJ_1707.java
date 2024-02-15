package Gold.IV;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static int K;
    static int V;
    static int E;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        while (K-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            color = new int[V + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

            while (E-- > 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            bfs();
        }
        System.out.print(sb);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= V; i++){
            if (color[i] == 0){
                queue.add(i);
                color[i] = 1;
            }

            while (!queue.isEmpty()){
                int now = queue.poll();     // 현재 정점

                for (int j = 0; j < graph.get(now).size(); j++){
                    int nextPoint = graph.get(now).get(j);          // 인접한 정점

                    // 아직 방문하지 않는 정점인 경우
                    if (color[nextPoint] == 0) queue.add(nextPoint);

                    // 인접한 정점과 색깔이 같은 경우
                    if (color[nextPoint] == color[now]) {
                        sb.append("NO").append('\n');
                        return;
                    }
                    
                    // 인접한 정점에 현재 정점과 다른 색깔 부여 (1 or 2)
                    if (color[nextPoint] == 0) color[nextPoint] = color[now] % 2 + 1;
                }
            }
        }
        sb.append("YES").append('\n');
    }
}
