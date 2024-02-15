package Gold.IV;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();
        Stack<Integer> nge = new Stack<>();
        boolean bool = false;

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()){
            inputStack.push(Integer.parseInt(st.nextToken()));
        }

        while(!inputStack.empty()){
            if (outputStack.empty()){
                nge.push(-1);
                outputStack.push(inputStack.pop());
            }
            else if (inputStack.peek() < outputStack.peek()){
                nge.push(outputStack.peek());
                outputStack.push(inputStack.pop());
            }
            else{
                while(!(inputStack.peek() < outputStack.peek())) {
                    outputStack.pop();

                    if (outputStack.empty()) {
                        nge.push(-1);
                        outputStack.push(inputStack.pop());
                        bool = true;
                        break;
                    }
                }
                if (bool) {
                    bool = false;
                    continue;
                }
                nge.push(outputStack.peek());
                outputStack.push(inputStack.pop());
            }
        }

        while (nge.size() != 1){
            sb.append(nge.pop()).append(' ');
        }
        sb.append(nge.pop());
        System.out.print(sb);
    }
}
