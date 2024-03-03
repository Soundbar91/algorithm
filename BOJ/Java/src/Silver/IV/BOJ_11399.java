package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int result = 0;
        int prev = 0;

        for (int i = 0; i < 1001; i++){
            while (arr[i]-- > 0) {
                result += (i + prev);
                prev += i;
            }
        }

        System.out.print(result);
    }
}
