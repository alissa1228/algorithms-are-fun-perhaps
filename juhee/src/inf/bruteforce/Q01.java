package inf.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 자릿수의 합 O(n^2)
 */
public class Q01 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        int biggest = 0;
        String answer = "0";
        for (int i = 0; i < n; i++) {
            String cur = st.nextToken();
            int sum = 0;
            for (int j = 0; j < cur.length(); j++) sum += Integer.parseInt(Character.toString(cur.charAt(j)));
            if (sum > biggest) {
                biggest = sum;
                answer = cur;
            } else if (sum == biggest && Integer.parseInt(cur) > Integer.parseInt(answer)) {
                biggest = sum;
                answer = cur;
            }
        }

        stdOut.write(answer);
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }
}
