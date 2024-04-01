package inf.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 회의실 배정
 */
public class Q01 {
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.end == m.end) return this.start - m.start;
            else return this.end - m.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        Meeting[] meetings = new Meeting[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
        int time = 0, cnt = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= time) {
                time = meeting.end;
                cnt++;
            }
        }
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
