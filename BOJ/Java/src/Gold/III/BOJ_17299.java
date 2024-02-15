package Gold.III;

import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> middleStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        int[] numCnt = new int[1000001];
        boolean bool = false;
        int index = 0;

        while (st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            inputStack.push(n);
            numCnt[n] += 1;
            index++;
        }

        while(!inputStack.empty()){
            if(middleStack.empty()){
                middleStack.push(inputStack.pop());
                outputStack.push(-1);
                continue;
            }
            else if (numCnt[inputStack.peek()] < numCnt[middleStack.peek()]){
                outputStack.push(middleStack.peek());
                middleStack.push(inputStack.pop());
                continue;
            }
            while (!(numCnt[inputStack.peek()] < numCnt[middleStack.peek()])){
                middleStack.pop();

                if (middleStack.empty()){
                    middleStack.push(inputStack.pop());
                    outputStack.push(-1);
                    bool = true;
                    break;
                }
            }
            if (bool == true){
                bool = false;
            }
            else {
                outputStack.push(middleStack.peek());
                middleStack.push(inputStack.pop());
            }
        }

        while (outputStack.size() != 1){
            sb.append(outputStack.pop()).append(' ');
        }
        sb.append(outputStack.pop());
        System.out.print(sb);
    }
}
