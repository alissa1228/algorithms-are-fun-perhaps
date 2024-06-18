package inf.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
 */
public class Q06 {
    /**
     * 0. 강연 클래스를 구현 후 필드 값으로 마감일과 보수를 선언
     * 1. 배열을 돌며 강연 마지막 날 구하기
     * 2. 우선순위큐로 강의 마감일 오름차순으로 정렬하기
     * 3. 마지막날부터 1일까지 배열을 돌며
     * 3-A. 인덱스보다 마감일이 크거나 같은 강연들에 대해서
     * 3-B. 보수가 가장 큰 강의 구한 후 총 수입에 더해주기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int answer = 0, endDate = Integer.MIN_VALUE, n = Integer.parseInt(stdIn.readLine());
        Lecture[] lectures = new Lecture[n];
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            int wage = Integer.parseInt(st.nextToken());
            int dueDate = Integer.parseInt(st.nextToken());
            endDate = Math.max(endDate, dueDate);
            lectures[i] = new Lecture(wage, dueDate);
        }

        Arrays.sort(lectures, (l1, l2) -> {
            if (l1.dueDate == l2.dueDate) return l2.wage - l1.wage;
            else return l2.dueDate - l1.dueDate;
        });

        int y = 0;
        // 강의 마감일부터 1일까지 loop를 돈다.
        for (int x = endDate; x > 0; x--) {
            // 강의 중 마감일이 해당 날짜보다 늦은 강의들을 우선 순위 큐에 저장한다.
            for (; y < n; y++) {
                if (lectures[y].dueDate >= x) pq.offer(lectures[y]);
                else break;
            }
            if (!pq.isEmpty()) {
                int wage = pq.poll().wage;
                answer += wage;
            }
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static class Lecture implements Comparable<Lecture>{

        int wage;
        int dueDate;

        public Lecture(int wage, int dueDate) {
            this.wage = wage;
            this.dueDate = dueDate;
        }

        @Override
        public String toString() {
            return "[" + this.wage + ", " + this.dueDate + "]";
        }

        @Override
        public int compareTo(Lecture l) {
            if (l.wage == this.wage) return l.dueDate - this.wage;
            else return l.wage - this.wage;
        }
    }
}
