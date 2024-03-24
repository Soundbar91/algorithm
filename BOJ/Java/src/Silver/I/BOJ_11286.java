package Silver.I;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
                else if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                return -1;
            }
        });

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) absHeap.add(x);
            else {
                if (absHeap.isEmpty()) sb.append(0).append('\n');
                else sb.append(absHeap.poll()).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
