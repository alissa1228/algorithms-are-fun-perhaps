package inf.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀함수
 */
public class Q01 {
    static void Recursive(int N) {
        if (N == 0) return;
        else {
            Recursive(N - 1);
            System.out.print(N + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        Recursive(Integer.parseInt(stdIn.readLine()));
    }
}
