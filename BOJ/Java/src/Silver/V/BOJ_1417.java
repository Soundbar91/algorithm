package Silver.V;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1417 {
    static int N;
    static int dasom;
    static Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dasom = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; i++) queue.add(Integer.parseInt(br.readLine()));

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int result = 0;

        while (!queue.isEmpty() && dasom <= queue.peek()) {
            dasom++;
            result++;
            queue.add(queue.poll() - 1);
        }

        return result;
    }
}
