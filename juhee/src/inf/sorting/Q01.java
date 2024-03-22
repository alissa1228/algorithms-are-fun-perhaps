package inf.sorting;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 선택 정렬: O(n^2)
 */
public class Q01 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int cursor = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] < cursor) {
                    cursor= arr[j];
                    arr[j] = arr[i];
                    arr[i] = cursor;
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
