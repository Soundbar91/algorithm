package Silver.II;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (queue.isEmpty()) sb.append(0).append('\n');
                else sb.append(queue.poll()).append('\n');
            }
            else queue.add(value);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
