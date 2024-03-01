package inf.stackandqueue;

import java.io.*;
import java.util.Stack;

public class Q01 {
    // Big-O: O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        String answer = "YES";
        char[] input = stdIn.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ')') {
                if (!stack.isEmpty() && stack.pop() == '(') continue;
                else {
                    answer = "NO";
                    break;
                }
            } else {
                stack.push(input[i]);
            }
        }
        if (!stack.isEmpty()) answer = "NO";
        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
