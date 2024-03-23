package inf.sorting;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Least Recently Used(카카오 캐시 문제 변형): O(n^2)
 */
public class Q05 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cache = new int[s];
        int[] works = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) works[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            int work = works[i];
            int idx = -1;
            for(int j = 0; j < s; j++) if (cache[j] == work) idx = j;
            if (idx >= 0) {
                for(int j = idx - 1; j > 0; j--) cache[j] = cache[j - 1];
            } else {
                for(int j = s - 1; j > 0; j--) cache[j] = cache[j - 1];
            }
            cache[0] = work;
        }
        for (int i = 0; i < s; i++) stdOut.write(cache[i] + " ");
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
