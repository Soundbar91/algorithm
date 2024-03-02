package Silver.I;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Meeting> queue = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.offer(new Meeting(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        int flag = queue.poll().endTime;
        int result = 1;

        while (!queue.isEmpty()) {
            Meeting meeting = queue.poll();
            if (flag <= meeting.startTime) {
                flag = meeting.endTime;
                result++;
            }
        }

        System.out.print(result);
    }

    static class Meeting implements Comparable<Meeting> {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Meeting other) {
            if (this.endTime == other.endTime) return this.startTime - other.startTime;
            else return Integer.compare(this.endTime, other.endTime);
        }
    }
}
