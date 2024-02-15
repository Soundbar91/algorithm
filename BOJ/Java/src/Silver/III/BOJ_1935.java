package Silver.III;

import java.io.*;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        int[] numArr = new int[n];
        int index = 0;

        while(index != n){
            numArr[index] = Integer.parseInt(br.readLine());
            index++;
        }

        for (char ch : str.toCharArray()){
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/'){
                double n1 = stack.pop();
                double n2 = stack.pop();
                stack.push(calc(n2, n1, ch));
            }
            else {
                int cnt = (int)ch - (int)'A';
                stack.push(((double) numArr[cnt]));
            }
        }
        System.out.printf("%.2f", stack.pop());
    }

    public static double calc(double n1, double n2, char ch){
        double result = 0.0;

        switch (ch) {
            case '+' :
                result = n1 + n2;
                break;
            case '-' :
                result = n1 - n2;
                break;
            case '*' :
                result = n1 * n2;
                break;
            case '/' :
                result = n1 / n2;
                break;
        };
        return result;
    }
}
