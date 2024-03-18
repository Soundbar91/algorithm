package Gold.IV;

import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            TreeMap<Integer, Integer> Q = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                solved(Q, st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
            }

            if (Q.isEmpty()) sb.append("EMPTY").append('\n');
            else {
                sb.append(Q.lastKey()).append(' ');
                sb.append(Q.firstKey()).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solved(TreeMap<Integer, Integer> Q, char order, int value) {
        if (order == 'I') Q.put(value, Q.getOrDefault(value , 0) + 1);
        else {
            if (Q.isEmpty()) return;

            int n = (value == 1) ? Q.lastKey() : Q.firstKey();
            if (Q.put(n, Q.get(n) - 1) == 1) Q.remove(n);
        }

    }
}
