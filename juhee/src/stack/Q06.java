package stack;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 공주 구하기
 */
public class Q06 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) queue.offer(i);
        int cnt = 0;
        while (queue.size() > 1) {
            Integer tmp = queue.poll();
            cnt++;
            if (cnt == k) {
                cnt = 0;
            } else {
                queue.offer(tmp);
            }
        }
        stdOut.write(String.valueOf(queue.poll()));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
