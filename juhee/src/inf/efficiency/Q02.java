package inf.efficiency;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2. 공통원소 구하기 (강의의 의도대로 푸는 방법)
 */
public class Q02 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(stdIn.readLine());
        int[] arr1 = new int[n];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(stdIn.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());

        int a = 0, b = 0;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ArrayList<Integer> list = new ArrayList<>();
        while (a < n && b < m) {
            // 두 원소가 같을 경우 해당 원소를 list에 추가한 후 각 인덱스를 증가한다.
            if (arr1[a] == arr2[b]) {
                list.add(arr1[a]);
                a++;
                b++;
                continue;
            }
            // 두 원소가 다를 경우 작은 원소의 인덱스를 증가한다.
            if (arr1[a] < arr2[b]) a++;
            if (arr2[b] < arr1[a]) b++;
        }
        for (Integer i : list) stdOut.write(i + " ");
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
