package string;

import java.io.*;

/**
 * 문자 찾기
 */
public class Q01{
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = stdIn.readLine().toUpperCase().toCharArray();
        char ch = stdIn.readLine().toUpperCase().charAt(0);
        int cnt = 0;
        for (char x : arr) if (x == ch) cnt++;
        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
