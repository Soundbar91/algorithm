package Silver.V;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;

public class BOJ_11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = m - 1; i >= 0; i--){
            int num = Integer.parseInt(st.nextToken());
            sum += (int) (num * Math.pow(A, i));
        }

        while (sum != 0){
            stack.push(sum % B);
            sum /= B;
        }

        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
