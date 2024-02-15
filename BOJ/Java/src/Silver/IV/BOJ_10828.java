package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                int num = Integer.parseInt(st.nextToken());
                top += 1;
                stack[top] = num;
                continue;
            }
            else if (order == 2) {
                if (top == -1) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(stack[top]));
                    top -= 1;
                }
            }
            else if (order == 3) {
                bw.write(String.valueOf(top + 1));
            }
            else if (order == 4) {
                if (top == -1) {
                    bw.write("1");
                } else {
                    bw.write("0");
                }
            } else {
                if (top == -1) {
                    bw.write("-1");
                } else {
                    bw.write(String.valueOf(stack[top]));
                }
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
