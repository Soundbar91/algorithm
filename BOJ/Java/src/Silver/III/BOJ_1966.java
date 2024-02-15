package Silver.III;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            Queue<int[]> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                queue.add(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int cnt = 0;

            while (true){
                int[] value = queue.poll();
                boolean bool = true;

                for (int[] valueQueue : queue){
                    if (valueQueue[1] > value[1]){
                        bool = false;
                        break;
                    }
                }

                if (bool){
                    cnt++;
                    if (value[0] == M) break;
                }
                else {
                    queue.add(value);
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}
