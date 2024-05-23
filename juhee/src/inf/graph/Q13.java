package inf.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 13. 수열 추측하기
 */
public class Q13 {
    static int N, bottom;
    static int[] ch, top;
    static int[][] comb;
    static boolean flag = true;

    static int getComb(int n, int r) {
        if (comb[n][r] != 0) return comb[n][r];
        if (r == 1) return comb[n][r] = n;
        if (n == r) return comb[n][r] = 1;
        if (r == 0) return comb[n][r] = 1;
        return comb[n][r] = getComb(n - 1, r - 1) + getComb(n - 1, r);
    }
    static void DFS(int L, int sum) {
        if (sum > bottom) return;
        if (flag) {
            if (L == N) {
                if (sum == bottom) {
                    for (int num : top) System.out.print(num + " ");
                    flag = false;
                }
            } else {
                for (int i = 1; i < N; i++) {
                    if (ch[i] != 1) {
                        ch[i] = 1;
                        top[L] = i;
                        DFS(L + 1, sum + getComb(N - 1, L) * i);
                        ch[i] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        bottom = Integer.parseInt(st.nextToken());
        ch = new int[bottom + 1];
        comb = new int[N + 1][N + 1];
        top = new int[N];
        DFS(0, 0);
    }
}
