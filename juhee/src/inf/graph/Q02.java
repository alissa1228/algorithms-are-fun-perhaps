package inf.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 재귀함수를 이용한 이진수 출력
 */
public class Q02 {
    static void Recursive(int N) {
        if (N == 0) return;
        else {
            Recursive(N / 2);
            System.out.print(N % 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        Recursive(Integer.parseInt(stdIn.readLine()));
    }
}
