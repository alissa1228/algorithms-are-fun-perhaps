package inf.stackandqueue;

import java.io.*;
import java.util.Stack;

public class Q02 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        char[] input = stdIn.readLine().toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            } else {
                stack.push(input[i]);
            }
        }
        for(int i = 0; i < stack.size(); i++) stdOut.write(stack.elementAt(i));
        stdOut.flush();
    }
}
