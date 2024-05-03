package Silver.I;

import java.io.*;

public class BOJ_21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.print(findMaxValue(str) + " \n" + findMinValue(str));

        br.close();
    }

    public static String findMaxValue(String str) {
       StringBuilder sb = new StringBuilder();

       for (int i = 0; i < str.length(); i++) {
           if (str.charAt(i) == 'M') {
               int index = i;

               while (index < str.length() && str.charAt(index) != 'K') index++;

               if (index == str.length()) sb.append("1".repeat(index - i));
               else sb.append("5").append("0".repeat(index - i));

               i = index;
           }
           else sb.append(5);
       }

       return sb.toString();
    }

    public static String findMinValue(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'M') {
                int index = i;

                while (index < str.length() && str.charAt(index) != 'K') index++;

                sb.append(1).append("0".repeat(index - (i + 1)));

                i = index - 1;
            }
            else sb.append(5);
        }

        return sb.toString();
    }
}
