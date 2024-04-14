package inf.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좌표정렬: O(n)
 */
public class Q07 {
    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        Coordinate[] list = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            list[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(list);
        for (int i = 0; i < n; i++) {
            stdOut.write(list[i].x + " " + list[i].y);
            if (i != n - 1) stdOut.write("\n");
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
