package Silver.II;

import java.io.*;
import java.util.Stack;
public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int cnt = 0;
        char preCh = ' ';

        for (char ch : str.toCharArray()){
            if (ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                char ch1 = stack.pop();

                if (ch1 == '('){
                    if (preCh == ')'){
                        cnt += 1;
                    }
                    else {
                        cnt += stack.size();
                    }
                }

            }
            preCh = ch;
        }
        System.out.println(cnt);
    }
}
