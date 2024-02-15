package Silver.III;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int computer;
    static int line;
    static int result;
    static boolean[] visit;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        visit = new boolean[computer + 1];

        for (int i = 0; i <= computer; i++) graph.add(new ArrayList<>());

        while (line-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);

        for (int i = 2; i < visit.length; i++){
            if (visit[i]) result++;
        }
        System.out.print(result);
    }

    public static void dfs(int startPoint){
        visit[startPoint] = true;
        stack.push(startPoint);

        while(!stack.empty()){
            int point = stack.pop();

            for (int i = 0; i < graph.get(point).size(); i++){
                int nextPoint = graph.get(point).get(i);
                if (!visit[nextPoint]) {
                    visit[nextPoint] = true;
                    stack.push(nextPoint);
                }
            }
        }
    }
}
