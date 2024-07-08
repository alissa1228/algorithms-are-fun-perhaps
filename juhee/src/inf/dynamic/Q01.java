package inf.dynamic;

import java.io.*;

/**
 * 1. 계단오르기
 */
public class Q01 {
    /**
     * 1. n번째 계단을 오르는 방법은 n-2계단까지 가서 2계단을 오르는 방법 + n - 1계단까지 가서 1계단을 오르는 방법이다.
     * 2. 따라서 동적계획법을 쓰면 된다...!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) arr[i] = arr[i - 1] + arr[i - 2];
        stdOut.write(String.valueOf(arr[n]));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
