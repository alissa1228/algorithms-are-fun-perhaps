package inf.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 현수야 재미없다: O(n^2)
 */
public class Q06 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] arr2 = arr.clone();
        Arrays.sort(arr2);
        String answer = "";
        for (int i = 0; i < n; i++) if (arr[i] != arr2[i]) answer += (i + 1) + " ";

        stdOut.write(answer);
        stdOut.close();
        stdIn.close();
    }
}
