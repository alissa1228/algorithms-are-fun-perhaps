package inf.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 결혼식: O(N^2)
 */
public class Q02 {
    static class Visit implements Comparable<Visit>{
        int start;
        int end;

        public Visit(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Visit v) {
            if (this.end == v.end) return this.start - v.start;
            else return this.end - v.end;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        Visit[] visits = new Visit[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            visits[i] = new Visit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 방문객 배열을 입장 순으로 정렬
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (visits[j].start > visits[j + 1].start) {
                    Visit tmp = visits[j];
                    visits[j] = visits[j + 1];
                    visits[j + 1] = tmp;
                }
            }
        }

        int answer = 0;
        PriorityQueue<Visit> pq = new PriorityQueue<>();
        for (Visit visit : visits) {
            while (!pq.isEmpty() && pq.peek().end <= visit.start) pq.poll();
            pq.offer(visit);
            answer = Math.max(answer, pq.size());
        }

        stdOut.write(String.valueOf(answer));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
