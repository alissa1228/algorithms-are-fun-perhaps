package inf.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5. 동전교환(냅색 알고리즘)
 */
public class Q05 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        String[] arr = stdIn.readLine().split(" ");
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(arr[i]);
        int m = Integer.parseInt(stdIn.readLine());
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= m; i++) {
                dy[i] = Math.min(dy[i - coin] + 1, dy[i]);
            }
//            System.out.println("dy = " + Arrays.toString(dy));
        }
        stdOut.write(String.valueOf(dy[m]));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
