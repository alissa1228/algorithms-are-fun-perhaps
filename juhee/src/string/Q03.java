package string;

import java.io.*;

/**
 * 문장 속 단어
 */
public class Q03 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = stdIn.readLine().split(" ");
        String longest = "";
        for (String x : arr) if (x.length() > longest.length()) longest = x;
        stdOut.write(longest);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
