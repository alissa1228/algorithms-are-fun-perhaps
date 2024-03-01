package inf.stackandqueue;

import java.io.*;
import java.util.*;

/**
 * 교육과정 설계
 */
public class Q07 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));

        String mc = stdIn.readLine();
        Queue<Character> queue = new LinkedList<>();
        String answer = "YES";
        for (int i = 0; i < mc.length(); i++) queue.offer(mc.charAt(i));
        char[] cc = stdIn.readLine().toCharArray();
        for (int i = 0; i < cc.length; i++) {
            if (mc.contains(String.valueOf(cc[i]))) {
                if (queue.peek() != cc[i]) {
                    answer = "NO";
                    break;
                }
                queue.poll();
            }
        }
        if (!queue.isEmpty()) answer = "NO";
        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
