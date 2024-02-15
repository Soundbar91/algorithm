package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = Integer.parseInt(br.readLine());

        int[] queue = new int[n];
        int front = 0;
        int back = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue[back] = num;
                back += 1;
                continue;
            }
            else if (order.equals("pop")) {
                if (front == back) {
                    str = "-1";
                    bw.write(str);
                } else {
                    str = String.valueOf(queue[front]);
                    bw.write(str);
                    front += 1;
                }
            }
            else if (order.equals("size")) {
                str = String.valueOf(back - front);
                bw.write(str);
            }
            else if (order.equals("empty")) {
                if (front == back) {
                    str = "1";
                    bw.write(str);
                } else {
                    str = "0";
                    bw.write(str);
                }
            }
            else if (order.equals("front")) {
                if (front == back) {
                    str = "-1";
                    bw.write(str);
                } else {
                    str = String.valueOf(queue[front]);
                    bw.write(str);
                }
            }
            else {
                if (front == back) {
                    str = "-1";
                    bw.write(str);
                } else {
                    str = String.valueOf(queue[back - 1]);
                    bw.write(str);
                }
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
