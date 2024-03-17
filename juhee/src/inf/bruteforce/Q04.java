package inf.bruteforce;

import java.io.*;
import java.util.*;

/**
 * 졸업 선물: O(n)
 */
public class Q04 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] inputs = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            inputs[i][0] = Integer.parseInt(st.nextToken());
            inputs[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputs, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparing((int[] a) -> a[1]));

        int cnt = 0;
        boolean isCouponUsed = false;

        for (int i = 0; i < n; i++) {
            int product = inputs[i][0];
            int delivery = inputs[i][1];
            if (m - product - delivery >= 0) {
                m -= (product + delivery);
                cnt++;
            } else if (!isCouponUsed && m - product/2 - delivery >= 0) {
                isCouponUsed = true;
                m -= (product/2 + delivery);
                cnt++;
            }
        }

        stdOut.write(String.valueOf(cnt));
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
