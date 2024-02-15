package Silver.II;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++){
            int minNum = 0;
            for (int j = 0; j < i; j++){
                if (numArr[i] < numArr[j]) minNum = Math.max(dp[j], minNum);
            }
            dp[i] = minNum + 1;
        }

        System.out.print(Arrays.stream(dp).max().getAsInt());

    }
}
