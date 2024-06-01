package Gold.IV;

import java.io.*;

public class BOJ_9663 {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        solve(N, 0, new int[N]);
        System.out.print(result);
        br.close();
    }

    public static void solve(int N, int row, int[] cols) {
        if (row == N) {
            result++;
            return ;
        }
        for (int i = 0; i < N; i++) {
            cols[row] = i;
            if (promising(row, cols)) solve(N, row + 1, cols);
        }
    }

    public static boolean promising(int row, int[] cols) {
        for (int i = 0; i < row; i++) {
            if (cols[row] == cols[i] || Math.abs(cols[i] - cols[row]) == Math.abs(row - i))
                return false;
        }
        return true;
    }
}
