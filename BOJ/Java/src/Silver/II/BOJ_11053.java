package Silver.II;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++){
            int numMax = 0;
            for (int j = 0; j < i; j++){
                if(numArr[i] > numArr[j]) numMax = Math.max(numMax, dp[j]);
            }
            dp[i] = numMax + 1;
        }

        System.out.print(Arrays.stream(dp).max().getAsInt());
    }
}
