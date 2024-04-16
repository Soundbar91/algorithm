package Gold.III;

import java.io.*;
import java.util.*;

public class BOJ_11779 {
    static int N;
    static int M;
    static int start;
    static int dest;
    static int[] dist;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<City>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dist = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            map.get(x).add(new City(y, wight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[start] = 0;

        solve();
    }

    public static void solve() {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));

        while (!pq.isEmpty()) {
            City curCity = pq.poll();

            if (visited[curCity.index]) continue;
            visited[curCity.index] = true;

            for (City nextCity : map.get(curCity.index)) {
                if (dist[nextCity.index] > dist[curCity.index] + nextCity.wight) {
                    dist[nextCity.index] = dist[curCity.index] + nextCity.wight;
                    pq.add(new City(nextCity.index, dist[nextCity.index]));
                    parent[nextCity.index] = curCity.index;
                }
            }
        }

        printResult();
    }

    public static class City implements Comparable<City> {
        int index;
        int wight;

        public City(int city, int wight) {
            this.index = city;
            this.wight = wight;
        }

        @Override
        public int compareTo(City o) {
            return wight - o.wight;
        }
    }

    public static void printResult() {
        Stack<Integer> stack = new Stack<>();
        System.out.println(dist[dest]);

        int index = dest;

        while (index != -1) {
            stack.push(index);
            index = parent[index];
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }
}
