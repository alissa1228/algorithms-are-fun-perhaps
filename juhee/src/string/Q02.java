package string;

import java.io.*;

/**
 * 대소문자 변환
 */
public class Q02 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = stdIn.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) arr[i] = Character.toLowerCase(arr[i]);
            else arr[i] = Character.toUpperCase(arr[i]);
        }

        stdOut.write(arr);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
