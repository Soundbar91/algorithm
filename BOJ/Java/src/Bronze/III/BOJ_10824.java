package Bronze.III;

import java.io.*;
import java.util.StringTokenizer;
public class BOJ_10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int n = st.countTokens();
        while(n != 2){
            sb1.append(st.nextToken());
            n--;
        }
        while(n != 0){
            sb2.append(st.nextToken());
            n--;
        }
        System.out.println(Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString()));
    }
}
