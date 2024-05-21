package inf.graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 10. 순열 구하기
 */
public class Q10 {
    static int N, M, cnt;
    static int[] arr, pm, ch;

    static void DFS(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) System.out.print(pm[i] + " ");
            System.out.println();
            cnt++;
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] != 1) {
                    pm[L] = arr[i];
                    ch[i] = 1;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];
        pm = new int[M];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        DFS(0);
        System.out.print(cnt);
    }
}
