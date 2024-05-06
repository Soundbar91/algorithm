package Gold.IV;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static int V;
    static int E;
    static int[] parents;
    static ArrayList<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];

        for (int i = 1; i <= V; i++) parents[i] = i;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.add(new Node(A, B, C));
        }

        System.out.print(solve());
    }

    public static long solve() {
        Collections.sort(list);
        long result = 0;
        int cnt = 0;

        for (Node node : list) {
            if (union(node.from, node.to)) {
                result += node.wight;
                if(cnt++ == E - 1) break;
            }
        }

        return result;
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return parents[x] = find(parents[x]);
    }

    public static boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return false;
        else parents[ry] = rx;
        return true;
    }

    public static class Node implements Comparable<Node> {
        int from;
        int to;
        int wight;

        public Node(int to, int from, int wight) {
            this.from = to;
            this.to = from;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return wight - o.wight;
        }
    }
}
