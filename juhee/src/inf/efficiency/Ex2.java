package inf.efficiency;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Ex2. 연속 부분수열 2
 */
public class Ex2 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int x = 0; x < n; x++) {
            int tmp = arr[x];
            if (tmp <= m) answer++;
            for (int y = x + 1; y < n; y++) {
                tmp += arr[y];
                if(tmp <= m) answer++;
                else break;
            }
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
