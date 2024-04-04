package Gold.V;

import java.io.*;
import java.util.*;

public class BOJ_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Class> classList = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            classList.add(new Class(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        Collections.sort(classList);
        System.out.print(solve(classList));
        br.close();
    }

    public static int solve(List<Class> classList) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (Class value : classList) {
            if (!priorityQueue.isEmpty() && value.startTime>= priorityQueue.peek()) priorityQueue.poll();
            priorityQueue.add(value.endTime);
        }

        return priorityQueue.size();
    }

    public static class Class implements Comparable<Class>{
        int startTime;
        int endTime;

        public Class(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Class other) {
            if (this.startTime == other.startTime) return this.endTime - other.endTime;
            else return Integer.compare(this.startTime, other.startTime);
        }
    }
}
