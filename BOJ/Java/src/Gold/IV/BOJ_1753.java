package Gold.IV;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static int V;
    static int E;
    static int K;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) map.add(new ArrayList<>());
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.get(u).add(new Node(v, w));
        }

        solve();
    }

    public static void solve() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            visited[node.node] = true;

            for (Node nextNode : map.get(node.node)) {
                if (visited[nextNode.node]) continue;
                if (dist[nextNode.node] > dist[node.node] + nextNode.weight) {
                    dist[nextNode.node] = dist[node.node] + nextNode.weight;
                    queue.add(new Node(nextNode.node, dist[nextNode.node]));
                }
            }
        }

        print();
    }

    public static void print() {
        for (int i = 1; i <= V; i++) System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
    }

    public static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}
