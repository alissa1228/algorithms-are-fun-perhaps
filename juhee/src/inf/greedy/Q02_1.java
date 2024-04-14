package inf.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 결혼식: O(NlonN)
 */
public class Q02_1 {
    static class Event implements Comparable<Event>{
        int type;
        int time;

        public Event(int type, int time) {
            this.type = type;
            this.time = time;
        }
        @Override
        public int compareTo(Event e) {
            if (this.time == e.time) return this.type - e.type;
            else return this.time - e.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        List<Event> events = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            events.add(new Event(1, Integer.parseInt(st.nextToken())));
            events.add(new Event(0, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(events);

        int answer = Integer.MIN_VALUE;
        int tmp = 0;
        for (Event event : events) {
            if (event.type == 0) tmp--;
            else tmp++;
            answer = Math.max(answer, tmp);
        }

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
