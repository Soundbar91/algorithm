package Bronze.V;

import java.io.*;
public class BOJ_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;

        for (int i = n; i > 0; i--){
            result *= i;
        }
        System.out.println(result);
    }
}
