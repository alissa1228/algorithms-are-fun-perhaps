package inf.greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 2. 회의실 배정
 */
public class Q04 {
    /**
     * 1. 회의에 대한 클래스 생성. 시작시간/종료시간을 필드로 선언
     * 2. Comparable 인터페이스를 상속받아서 종료 시간 순으로 정렬하도록 오버라이드
     * 3. 우선순위 큐를 활용하여 회의 클래스를 저장
     * 4. 우선순위 큐가 빌때까지 loop를 돌며 사용 가능한 회의실을 체크
     * 5. 이 때 회의 클래스는 회의 종료시간이 빠른 회의부터 나오게 됨.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        PriorityQueue<Meeting> meetings = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            meetings.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int answer = 1;
        Meeting cm = meetings.poll();
        while (!meetings.isEmpty()) {
            Meeting tmp = meetings.poll();
            if (cm.end <= tmp.start) {
                cm = tmp;
                answer++;
            }
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if (this.end == meeting.end) return this.start - meeting.start;
            else return this.end - meeting.end;
        }
    }
}
