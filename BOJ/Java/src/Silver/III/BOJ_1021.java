package Silver.III;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    static LinkedList<Integer> deque = new LinkedList<>();
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        for (int i = 1; i <= N; i++) deque.offer(i);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());

        System.out.print(solve());
    }

    public static int solve() {
        int count = 0;

        for(int i = 0; i < M; i++) {
            int index = deque.indexOf(arr[i]);
            int half;

            if(deque.size() % 2 == 0) {
                half = deque.size() / 2 - 1;
            }
            else {
                half = deque.size() / 2;
            }

            if(index <= half) {
                for(int j = 0; j < index; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {
                for(int j = 0; j < deque.size() - index; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }

            }
            deque.pollFirst();
        }

        return count;
    }
}
