package inf.bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

/**
 * 뒤집은 소수: O(N^2)
 */
public class Q02 {
    static int[] primeNumbers;

    static void findPrimeNumber(int number) {
        for (int i = 3; i <= number; i++) {
            boolean isPrimeNumber = false;
            if (primeNumbers[i] == 0) continue; // 해당 숫자가 이미 소수가 아닐경우 통과
            for (int j = 2; j < i; j++) { // 자신보다 작은 소수들로 나누어 보는 반복문
                if (primeNumbers[j] == 0) continue; // 나눠줄 숫자가 소수가 아닐경우 통과
                else {
                    if (i % primeNumbers[j] == 0) primeNumbers[i] = 0; // 소수로 나눠질 경우 해당 숫자는 소수가 아님
                    else isPrimeNumber= true;
                }
            }
            if(isPrimeNumber) { // 해당 loop의 숫자가 소수인 것이 확인될 경우 전체 리스트에 대해서 해당 소수로 나누어 지는 수는 소수가 아님.
                for (int j = i + 1; j < primeNumbers.length - 1; j++) if (primeNumbers[j] != 0 && primeNumbers[j] % i == 0) primeNumbers[j] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        int[] answer = new int[n];
        int[] input = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer(st.nextToken());
            input[i] = Integer.parseInt(sb.reverse().toString());
        }
        OptionalInt max = Arrays.stream(input).max();
        if (max.isPresent()) {
            primeNumbers = new int[max.getAsInt() + 1];
            for (int i = 2; i <= max.getAsInt(); i++) primeNumbers[i] = i;

            findPrimeNumber(max.getAsInt());
        }
        for (int i = 0; i < n; i++) if (primeNumbers[input[i]] != 0) stdOut.write(String.valueOf(input[i]) + " ");
        stdOut.flush();

        stdOut.close();
        stdIn.close();
    }

}
