package inf.stackandqueue;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q03 {
    // Big-O: O(n^2)
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        int[][] board = new int[n + 1][n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int m = Integer.parseInt(stdIn.readLine());
        int[] moves = new int[m];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < m; i++) moves[i] = Integer.parseInt(st.nextToken());

        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i <= n; i++) stacks.add(new Stack<>());
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= 1; j--) {
                if (board[j][i] != 0) stacks.get(i).push(board[j][i]);
            }
        }
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            if (stacks.get(move).isEmpty()) break;
            Integer pop = stacks.get(move).pop();
            if (!basket.isEmpty() && basket.peek().equals(pop)) {
                basket.pop();
                answer += 2;
            } else {
                basket.push(pop);
            }
        }

        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}