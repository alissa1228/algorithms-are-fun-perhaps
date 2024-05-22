package inf.graph;

import java.io.*;
import java.util.StringTokenizer;

public class Q11 {
    static int DFS(int L) {
        if (L == 1) return 1;
        else return L * DFS(L - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        stdOut.write(String.valueOf(DFS(Integer.parseInt(stdIn.readLine()))));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
