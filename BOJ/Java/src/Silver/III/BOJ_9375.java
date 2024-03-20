package Silver.III;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String part = st.nextToken();

                map.put(part, map.getOrDefault(part, 0) + 1);
            }

            sb.append(solve(map)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static int solve(HashMap<String, Integer> map) {
        int result = 1;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result *= (entry.getValue() + 1);
        }

        return result - 1;
    }
}
