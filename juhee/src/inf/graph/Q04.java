package inf.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부분집합 구하기(DFS)
 */
public class Q04 {
    static int n;
    static int[] ch;

    static void DFS(int L) {
        if (L == n + 1) {
            for (int i = 1; i <= n; i++) if (ch[i] == 1) System.out.print(i + " ");
            System.out.println();
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(stdIn.readLine());
        ch = new int[n + 1];
        DFS(1);
    }

}
