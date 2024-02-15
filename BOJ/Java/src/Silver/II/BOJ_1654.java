package Silver.II;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static int N;
    public static int K;
    public static long[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        numArr = new long[K + 1];
        for (int i = 1; i <= K; i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }

        long numMax = Arrays.stream(numArr).max().getAsLong();
        System.out.print(binarySearch(1, numMax));
    }

    public static int binarySearch(long low, long high){
        if (low > high) return (int) high;

        long middle = (low + high) / 2;
        int cnt = 0;

        for (int i = 1; i <= K; i++){
            cnt += (int) (numArr[i] / middle);
        }

        if (cnt < N) return binarySearch(low, middle - 1);
        else return binarySearch(middle + 1, high);
    }
}
