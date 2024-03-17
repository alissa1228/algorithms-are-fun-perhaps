package inf.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 멘토링
 */
public class Q03 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] testResult = new int[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 1; j <= n; j++) {
                int idx = Integer.parseInt(st.nextToken());
                testResult[idx][i] = j; // idx번째 학생은 i번째 시험에서 j등을 하였다.
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    boolean isBetter = true;
                    for (int k = 1; k <= m; k++) {
                        if (testResult[i][k] > testResult[j][k]) {
                            isBetter = false;
                            break;
                        }
                    }
                    if (isBetter) cnt++;
                }
            }
        }

        stdOut.write(String.valueOf(cnt));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
