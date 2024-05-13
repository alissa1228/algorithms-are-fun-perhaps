package inf.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 바둑이 승차(DFS)
 */
public class Q06 {
    static int C, N, MAX = Integer.MIN_VALUE;
    static int[] arr, ch;

    static void DFS(int L) {
        if (L == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) if (ch[i] == 1) sum += arr[i];
            if (sum <= C) MAX = Math.max(MAX, sum);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(stdIn.readLine());
        DFS(0);
        stdOut.write(String.valueOf(MAX));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
