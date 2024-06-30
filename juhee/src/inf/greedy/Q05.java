package inf.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 3. 결혼식
 */
public class Q05 {
    /**
     * 0. 손님 클래스를 생성. 필드 값으로 입장/퇴장 시간을 선언
     * 1. 퇴장순으로 오름차순인 우선순위 큐를 선언
     * 2. 배열을 입장 시간 순으로 정렬 => Arrays.sort(stream)
     * 3. 배열에 대하여 loop를 돌며 해당 손님의 시간을 기준으로 큐에서 퇴장해야할 손님을 입력
     * 4. 해당 손님을 큐에 저장 후 큐의 크기를 비교
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        Guest[] guests = new Guest[n];
        PriorityQueue<Guest> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            guests[i] = new Guest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(guests, (a, b) -> {
            if (a.in == b.in) return a.out - b.out;
            else return a.in - b.in;
        });
        int answer = 0;
        for (Guest guest : guests) {
            // 손님 퇴장 처리 로직: 우선순위큐가 비어있지 않을 때 비교
            while (!pq.isEmpty() && pq.peek().out <= guest.in) pq.poll();
            // 손님 입장 처리 로직
            pq.offer(guest);
            // 최대 인원 비교 로직
            answer = Math.max(answer, pq.size());
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static class Guest implements Comparable<Guest>{
        int in;
        int out;

        public Guest(int in, int out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public String toString() {
            return "[" + this.in + ", " + this.out + "]";
        }

        @Override
        public int compareTo(Guest guest) {
            if (this.out == guest.out) return this.in - guest.in;
            else return this.out - guest.out;
        }
    }
}
