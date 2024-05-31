package inf.graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 15. 수들의 조합
 */
public class Q15 {
    static int N, K, M, cnt;
    static int[] arr, ch, comb;

    static void DFS(int L, int D) {
        if (L == K) {
            int sum = Arrays.stream(comb).sum();
            if (ch[sum] == 0) {
                if (sum % M == 0) {
                    cnt++;
                    ch[sum] = 1;
                }
            }
        } else {
            for (int i = D; i < N; i++) {
                comb[L] = arr[i];
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        comb = new int[K];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        ch = new int[Arrays.stream(arr).sum() + 1];
        M = Integer.parseInt(stdIn.readLine());
        DFS(0, 0);
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
