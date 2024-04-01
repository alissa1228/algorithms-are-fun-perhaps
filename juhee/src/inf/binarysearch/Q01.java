package inf.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분 검색: O(NlogN)
 */
public class Q01 {
    static int binarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1, result = -1;
        Arrays.sort(arr);
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid + 1;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        stdOut.write(String.valueOf(binarySearch(arr, target)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
