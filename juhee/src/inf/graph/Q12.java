package inf.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 12. 조합의 경우수(메모이제이션)
 */
public class Q12 {
    static int[][] arr;
    static int comb(int n, int r) {
        if (r == 1) return arr[n][r] = n;
        if (n == r || r == 0) return arr[n][r] =  1;
        if (arr[n][r] != 0) return arr[n][r];
        else return arr[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][r + 1];
        stdOut.write(String.valueOf(comb(n, r)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
