package inf.stackandqueue;

import java.io.*;
import java.util.Stack;

/**
 * 후위식 연산(postfix)
 */
public class Q04 {
    // Big-O: O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = stdIn.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '+' ) {
                Integer to = stack.pop();
                Integer from = stack.pop();
                stack.push(from + to);
            } else if (input[i] == '-') {
                Integer to = stack.pop();
                Integer from = stack.pop();
                stack.push(from - to);
            } else if (input[i] == '*') {
                Integer to = stack.pop();
                Integer from = stack.pop();
                stack.push(from * to);
            } else if (input[i] == '/') {
                Integer to = stack.pop();
                Integer from = stack.pop();
                stack.push(from / to);
            } else {
                stack.push(Character.getNumericValue(input[i]));
            }
        }
        stdOut.write(String.valueOf(stack.pop()));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
