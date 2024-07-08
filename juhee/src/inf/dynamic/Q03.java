package inf.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 3. 최대 부분 증가수열
 */
public class Q03 {
    /**
     * 1. dy[i]는 arr[i]의 값을 마지막 항으로 하는 배열의 최대 길이
     * 2. dy[0] = 1로 초기화
     * 3. 1부터 n까지 loop를 돌며 arr[n]의 값이 앞의 인덱스들의 값보다 크면 dy[i] + 1의 값을 할당
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n];
        int[] dy = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dy[0] = 1;
        for (int x = 1; x < n; x++) {
            int max = 1;
            for (int y = 0; y <= x - 1; y++) {
                if (arr[x] > arr[y]) max = Math.max(dy[y] + 1, max);
            }
            dy[x] = max;
        }
        stdOut.write(String.valueOf(Arrays.stream(dy).max().getAsInt()));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
