package Bronze.I;

import java.io.*;

public class BOJ_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] numArr = new int[15][15];

        for (int i = 1; i <= 14; i++){
            numArr[0][i] = i;
            numArr[i][1] = 1;
        }

        for (int i = 1; i <= 14; i++){
            for (int j = 2; j <= 14; j++){
                numArr[i][j] = numArr[i][j - 1] + numArr[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(numArr[k][n]).append('\n');
        }
        System.out.print(sb);
    }
}
