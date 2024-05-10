package Gold.IV;

import java.io.*;
import java.util.*;

public class BOJ_21924 {
    static int N;
    static int M;
    static long total;
    static int[] parents;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            list.add(new Node(from, to, weight));
            total += weight;
        }

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        Collections.sort(list);
        long result = 0;
        int cnt = 0;

        for (Node node : list) {
            if (union(node.from, node.to)) {
                result += node.wight;
                if (++cnt == N - 1) return total - result;
            }
        }

        return -1;
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return find(parents[x]);
    }

    public static boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return false;
        else {
            if (rx < ry) parents[ry] = rx;
            else parents[rx] = ry;
        }
        return true;
    }

    public static class Node implements Comparable<Node> {
        int from;
        int to;
        long wight;

        public Node(int to, int from, long wight) {
            this.from = to;
            this.to = from;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (wight - o.wight);
        }
    }
}
