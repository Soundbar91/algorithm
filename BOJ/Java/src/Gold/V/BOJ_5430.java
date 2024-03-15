package Gold.V;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Deque<Integer> deque = new ArrayDeque<>();
            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            while (n-- > 0) deque.add(Integer.parseInt(st.nextToken()));

            AC(p, deque);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void AC(char[] p, Deque<Integer> deque) {
        boolean reversed = false;

        for (int i = 0; i < p.length; i++) {
            if (p[i] == 'D' && deque.isEmpty()) {
                sb.append("error").append('\n');
                return;
            }

            if (p[i] == 'R') reversed = !reversed;
            else {
                if (reversed) deque.pollLast();
                else deque.pollFirst();
            }
        }

        Print(reversed, deque);
    }

    public static void Print(boolean reversed, Deque<Integer> deque) {
        sb.append('[');

        if(!deque.isEmpty()) {
            if(!reversed) {
                sb.append(deque.pollFirst());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else {
                sb.append(deque.pollLast());

                while(!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }
}
