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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numArr[i] = Integer.parseInt(st.nextToken());

        int result = solve(0, 0, N, S, numArr);

        if (S == 0) result--;
        System.out.println(result);
    }

    public static int solve(int depth, int sum, int N, int S, int[] A) {
        if (depth == N) {
            if (sum == S) return 1;
            else return 0;
        }

        int count = 0;
        count += solve(depth + 1, sum + A[depth], N, S, A);
        count += solve(depth + 1, sum, N, S, A);

        return count;
    }
}
