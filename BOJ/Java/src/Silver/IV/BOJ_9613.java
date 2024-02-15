package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int[] numArr = new int[cnt];
            long result = 0;

            for (int i = 0; i < numArr.length; i++){
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < numArr.length - 1; i++) {
                for (int j = i + 1; j < numArr.length; j++) {
                    int p = numArr[i];
                    int q = numArr[j];

                    while (q != 0){
                        int temp = q;
                        q = p % q;
                        p = temp;
                    }

                    result += p;
                }
            }
            sb.append(String.valueOf(result)).append('\n');
        }
        System.out.print(sb);
    }
}
