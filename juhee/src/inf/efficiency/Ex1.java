package inf.efficiency;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Ex1. 연속 부분수열 1
 */
public class Ex1 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int lt = 0, rt = 1, sum = arr[0], answer = 0;
        while (lt < n && rt < n) {
            if (sum == m) {
                answer++;
                sum -= arr[lt++];
                continue;
            }
            if (sum < m) sum += arr[rt++];
            else sum -= arr[lt++];
        }
        if (sum == m) answer++;
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
