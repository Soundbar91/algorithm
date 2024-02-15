package Silver.II;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numArr = new int[N];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < (1 << N); i++){ /* 부분 순열 */
            int sum = 0;
            for (int j = 0; j < N; j++){ /* 부분 순열에 어느 원소가 포함되어 있는지 */
                if ((i & (1 << j)) != 0) sum += numArr[j];
            }
            if (sum == S) result++;
        }

        System.out.print(result);
    }
}
