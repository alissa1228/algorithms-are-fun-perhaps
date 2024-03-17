package inf.bruteforce;

import java.io.*;
import java.util.*;

/**
 * K번째 큰 수: O(N^3)
 */
public class Q05 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(stdIn.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int z = 0; z < n; z++) {
                    if (x != y && y != z && x != z) {
                        set.add(arr[x] + arr[y] + arr[z]);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(set.stream().toList());
        list.sort(Collections.reverseOrder());
        stdOut.write(String.valueOf(list.get(m - 1)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
