package Silver.II;

import java.io.*;
import java.util.*;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int result = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer st1 = new StringTokenizer(st.nextToken(), "+");

            while (st1.hasMoreTokens()) {
                temp += Integer.parseInt(st1.nextToken());
            }

            if (result == Integer.MAX_VALUE) result = temp;
            else result -= temp;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
