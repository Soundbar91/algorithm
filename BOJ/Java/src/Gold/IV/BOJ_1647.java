package Gold.IV;

import java.io.*;
import java.util.*;
import java.util.List;

public class BOJ_1647 {
    static int N;
    static int M;
    static List<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new List[N + 1];

        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, wight));
            map[to].add(new Node(from, wight));
        }

        System.out.print(solve());
    }

    public static long solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(1, 0));
        long maxValue = -1;
        long result = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) continue;
            visited[node.to] = true;
            result += node.wight;
            maxValue = Math.max(maxValue, node.wight);

            for (Node next : map[node.to]) {
                if (!visited[next.to]) pq.add(new Node(next.to, next.wight));
            }
        }

        return result - maxValue;
    }

    public static class Node implements Comparable<Node> {
        int to;
        int wight;

        public Node(int to, int wight) {
            this.to = to;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return wight - o.wight;
        }
    }
}
