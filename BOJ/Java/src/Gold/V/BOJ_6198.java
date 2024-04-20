package Gold.V;

import java.io.*;
import java.util.Stack;

public class BOJ_6198 {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        System.out.print(solve());
    }

    public static long solve() {
        Stack<Integer> stack = new Stack<>();

        long result = 0;

        for (int i = 0; i < N; i++) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
                result += stack.size();
            }
            stack.push(nums[i]);
        }

        while (!stack.empty()) {
            stack.pop();
            result += stack.size();
        }

        return result;
    }
}
