package inf.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 6. 최대점수 구하기(냅색 알고리즘)
 */
public class Q06 {
	public static void main(String[] args) throws IOException {
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(stdIn.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dy = new int[m + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(stdIn.readLine());
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			for (int j = m; j >= time; j--) {
				dy[j] = Math.max(dy[j], dy[j - time] + score);
			}
		}
		stdOut.write(String.valueOf(dy[m]));
		stdOut.flush();
		stdOut.close();
		stdIn.close();
	}
}