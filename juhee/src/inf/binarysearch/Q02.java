package inf.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 마구간: O(N^2)
 */
public class Q02 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {arr[i] = Integer.parseInt(st.nextToken());}
        Arrays.sort(arr);
        int start = 1;
        int end = Arrays.stream(arr).max().getAsInt();
        int answer = Integer.MIN_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2, cnt = 1, cur = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - cur >= mid) {
                    cur = arr[i];
                    cnt++;
                }
            }

            if (cnt >= m) {
                answer = Math.max(mid, answer);
                start = mid + 1;
            } else end = mid - 1;
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
