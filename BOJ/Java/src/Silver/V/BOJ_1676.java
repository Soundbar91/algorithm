package Silver.V;

import java.io.*;

public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 1; i <= n; i++){
            int temp = i;
            while (temp % 5 == 0){
                cnt++;
                temp /= 5;
            }
        }

        System.out.print(cnt);
    }
}
