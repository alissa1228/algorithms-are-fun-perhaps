package inf.graph;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 합이 같은 부분집합(DFS : 아마존 인터뷰)
 */
public class Q05 {
    static int N, sum;
    static int[] ch, arr;
    static String ANSWER = "NO";

    static void DFS(int L) {
        if (L == N) {
            int tmp = 0;
            for (int i = 0; i < N; i++) if (ch[i] == 1) tmp += arr[i];
            if (tmp == sum - tmp) ANSWER = "YES";
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(stdIn.readLine());
        ch = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        sum = Arrays.stream(arr).sum();
        DFS(0);
        stdOut.write(ANSWER);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
