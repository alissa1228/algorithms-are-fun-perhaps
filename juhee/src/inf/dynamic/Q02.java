package inf.dynamic;

import java.io.*;

/**
 * 2. 돌다리 건너기
 */
public class Q02 {
    /**
     * 1. n번째 돌로 가는 방법은 n - 1에서 가는 방법과 n - 2번째 돌에서 가는 방법이 있다.
     * 2. 따라서 동적계획법을 쓰면 된다...!
     * 3. 이번에는 대신 n이 아니라 완전히 건너야하기 때문에 n + 1 번재 돌로 가는 방법을 반환해야한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        int[] arr = new int[n + 2];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n + 1; i++) arr[i] = arr[i - 1] + arr[i - 2];
        stdOut.write(String.valueOf(arr[n + 1]));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
