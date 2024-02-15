package Silver.IV;

import java.util.Stack;
import java.io.*;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean bool = false;
        StringBuilder sb = new StringBuilder();

        while(n-- > 0){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for (char ch : str.toCharArray()){
                if (ch == ')'){
                    if (stack.empty()){
                        bool = true;
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else {
                    stack.push(ch);
                }
            }

            if (bool == true) {
                sb.append("NO");
                bool = false;
            }
            else if (!stack.empty()) {
                sb.append("NO");
            }
            else{
                sb.append("YES");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
