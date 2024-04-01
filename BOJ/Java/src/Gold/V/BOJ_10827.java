package Gold.V;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class BOJ_10827 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigDecimal a = new BigDecimal(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.print(solve(a, b).toPlainString());
        br.close();
    }

    public static BigDecimal solve(BigDecimal a, int b) {
        if (b == 0) return new BigDecimal("1");
        if (b == 1) return a;

        if (b % 2 != 0) {
            return solve(a, b - 1).multiply(a);
        }
        else {
            BigDecimal ret = solve(a, b / 2);
            return ret.multiply(ret);
        }
    }
}
