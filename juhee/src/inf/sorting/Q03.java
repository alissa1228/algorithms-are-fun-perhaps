package inf.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Special Sort(구글 인터뷰): O(N^2)
 */
public class Q03 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String str = String.valueOf(arr[i]);
            if (i < n - 1) str += " ";
            stdOut.write(str);
        }
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
