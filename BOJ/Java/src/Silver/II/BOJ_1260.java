package Silver.II;

import java.io.*;
import java.util.*;

public class BOJ_1260 {
    static int N;
    static int M;
    static int V;
    static int[] visitDFS;
    static int[] visitBFS;
    static int depth = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i));
        visit = new boolean[N + 1];
        visitDFS = new int[N + 1];
        DFS(V);

        for (int i = 1; i < depth; i++) System.out.print(visitDFS[i] + " ");

        depth = 1;
        visit = new boolean[N + 1];
        visitBFS = new int[N + 1];
        BFS(V);

        System.out.println();
        for (int i = 1; i < depth; i++) System.out.print(visitBFS[i] + " ");
    }

    public static void DFS(int startPoint){
        visit[startPoint] = true;
        stack.push(startPoint);

        while(!stack.empty()){
            int point = stack.pop();
            visitDFS[depth++] = point;

            for (int i = 0; i < graph.get(point).size(); i++){
                int nextPoint = graph.get(point).get(i);
                if (!visit[nextPoint]){
                    DFS(nextPoint);
                }
            }
        }
    }

    public static void BFS(int startPoint){
        visit[startPoint] = true;
        queue.add(startPoint);

        while(!queue.isEmpty()){
            int point = queue.poll();
            visitBFS[depth++] = point;

            for (int i = 0; i < graph.get(point).size(); i++){
                int nextPoint = graph.get(point).get(i);
                if (!visit[nextPoint]) {
                    visit[nextPoint] = true;
                    queue.add(nextPoint);
                }
            }
        }
    }
}
