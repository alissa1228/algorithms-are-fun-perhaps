package inf.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  뮤직비디오: O(n^2)
 */
public class Q03 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int answer = rt;
        while(lt <= rt) {
            int mid = (lt + rt) / 2, sum = 0, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + arr[i] > mid) { // 합이 클 경우 dvd 개수 추가 후 sum을 arr[i]의 값으로
                    sum = arr[i];
                    cnt++;
                } else if (sum + arr[i] == mid) { // 합이 같을 경우 dvd 개수 추가 후 sum을 0으로
                    sum = 0;
                    cnt++;
                } else {
                    sum += arr[i]; // 합이 작을 경우 sum 추가
                }
            }
            if (sum != 0) cnt++; // 남아있을 경우 dvd 개수 추가
            if (cnt <= m) { // 목표 dvd 개수보다 덜 나올 경우
                answer = Math.min(answer, mid);
                rt = mid -1; // 한 dvd에 많은 노래를 담는다.
            } else lt = mid + 1; // 목표 dvd 개수보다 더 나올 경우 한 dvd에 더 많은 노래를 담는다.
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
