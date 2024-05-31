package inf.graph;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 9. 동전교환
 */
public class Q09 {
    static int N, M, answer = Integer.MAX_VALUE;
    static Integer[] coins;

    static void DFS(int num, int cnt) {
        if (cnt > answer || num < 0) return;
        if (num == 0) {
            answer = Math.min(answer, cnt);
        } else {
            for (int i = 0; i < N; i++) {
                DFS(num - coins[i], cnt + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(stdIn.readLine());
        coins = new Integer[N];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(coins, Collections.reverseOrder());
        M = Integer.parseInt(stdIn.readLine());
        DFS(M, 0);
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
