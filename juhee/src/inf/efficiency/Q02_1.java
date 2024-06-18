package inf.efficiency;

import java.io.*;
import java.util.*;

/**
 *  2. 공통원소 구하기 (내 맘대로 방법)
 */
public class Q02_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(stdIn.readLine());
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(stdIn.readLine());
        st = new StringTokenizer(stdIn.readLine());
        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (set.contains(tmp)) {
                list.add(tmp);
            }
        }
        Collections.sort(list);
        for (Integer i : list) stdOut.write(i + " ");
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
