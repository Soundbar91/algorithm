package Gold.V;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];

        if(M == 0){
            System.out.print(Math.min(Math.abs(N - 100), String.valueOf(N).length()));
        }

        else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                broken[Integer.parseInt(st.nextToken())] = true;
            }

            System.out.print(solved(N, broken));
        }
    }

    private static int solved(int N, boolean[] broken) {
        int result = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++){
            String str = String.valueOf(i);
            int len = str.length();
            boolean bool = false;

            for (int j = 0; j < len; j++){
                if(broken[str.charAt(j) - '0']){
                    bool = true;
                    break;
                }
            }

            if(!bool){
                int value = Math.abs(N - Integer.parseInt(str)) + len;
                result = Math.min(result, value);
            }
        }
        return result;
    }
}
