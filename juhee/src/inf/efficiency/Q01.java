package inf.efficiency;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 두 배열 합치기
 */
public class Q01 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr1 = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(stdIn.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());

        int a = 0, b = 0, idx = 0;
        int[] answer = new int[n + m];
        while (a < n && b < m) {
            if (arr1[a] < arr2[b]) {
                answer[idx++] = arr1[a++];
            } else {
                answer[idx++] = arr2[b++];
            }
        }
        if (a < n) for (int i = a; i < n; i++) answer[idx++] = arr1[i];
        if (b < m) for (int i = b; i < m; i++) answer[idx++] = arr2[i];


        for (int i = 0; i < n + m; i++) {
            stdOut.write(String.valueOf(answer[i]));
            if (i != n + m - 1) stdOut.write(" ");
        }

        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
