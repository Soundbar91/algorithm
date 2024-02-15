package Bronze.I;

import java.io.*;
import java.util.StringTokenizer;
public class BOJ_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int k = 2;
            int gcd = 1;

            while (k <= A && k <= B){
                if (A % k == 0 && B % k == 0) gcd = k;
                k++;
            }
            sb.append((A*B) / gcd).append('\n');
        }

        System.out.println(sb);
    }
}
