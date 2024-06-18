package inf.efficiency;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 최대 매출
 */
public class Q03 {
    /**
     * 0. 슬라이딩 윈도우 알고리즘 활용
     * 1. 연속된 m일의 매출합계의 변수 sum을 초기 m일의 매출합계로 초기화
     * 2. index를 m + 1부터 진행하여 index일의 매출을 더해주고 index - m일의 매출을 빼줌
     * 3. 계산된 매출이 최대 값인지 Math.max()를 활용하여 비교
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] sales = new int[n];
        int sum = 0;
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) {
            int sale = Integer.parseInt(st.nextToken());
            sales[i] = sale;
            if (i <= k - 1) sum += sale;
        }
        int answer = sum;
        for (int i = k; i < n; i++) {
            sum = sum + sales[i] - sales[i - k];
            answer = Math.max(answer, sum);
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
