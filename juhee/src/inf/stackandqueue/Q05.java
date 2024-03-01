package inf.stackandqueue;

import java.io.*;
import java.util.Stack;

/**
 * 쇠막대기
 */
public class Q05 {
    // Big-O: O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = stdIn.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(input[0]);
        int cnt = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == ')') {
                if (input[i - 1] == input[i]) {
                    stack.pop();
                    cnt++;
                } else {
                    stack.pop();
                    cnt += stack.size();
                }
            } else {
                stack.push(input[i]);
            }
        }
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
