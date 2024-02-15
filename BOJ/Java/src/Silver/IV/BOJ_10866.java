package Silver.IV;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] deque = new int[n];
        int front = 0;
        int back = 0;

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if (order.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deque[front] = num;
                front = (front - 1 + n) % n;
                continue;
            }
            else if (order.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                back = (back + 1) % n;
                deque[back] = num;
                continue;
            }
            else if (order.equals("pop_front")){
                if (back == front){
                    bw.write("-1");
                }
                else {
                    front = (front + 1) % n;
                    bw.write(String.valueOf(deque[front]));
                }
            }
            else if (order.equals("pop_back")){
                if (back == front){
                    bw.write("-1");
                }
                else {
                    bw.write(String.valueOf(deque[back]));
                    back = (back - 1 + n) % n;
                }
            }
            else if (order.equals("size")){
                bw.write(String.valueOf((back - front + n) % n));
            }
            else if (order.equals("empty")){
                if (back == front){
                    bw.write("1");
                }
                else {
                    bw.write("0");
                }
            }
            else if (order.equals("front")){
                if (back == front){
                    bw.write("-1");
                }
                else {
                    bw.write(String.valueOf(deque[(front + 1) % n]));
                }
            }
            else {
                if (back == front){
                    bw.write("-1");
                }
                else {
                    bw.write(String.valueOf(deque[back]));
                }
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
