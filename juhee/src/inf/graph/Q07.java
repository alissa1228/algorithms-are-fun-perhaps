package inf.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 최대점수 구하기(DFS)
 */
public class Q07 {
    static int N, M, MAX = Integer.MIN_VALUE;
    static int[] ch, points, time;

    static void DFS(int L) {
        if (L == N) {
            int totalTime = 0, totalPoints = 0;
            for (int i = 0; i < N; i++) {
                if (ch[i] == 1) {
                    totalTime += time[i];
                    totalPoints += points[i];
                }
            }
            if (totalTime <= M) MAX = Math.max(MAX, totalPoints);
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
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N];
        points = new int[N];
        time = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(stdIn.readLine());
            points[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0);
        stdOut.write(String.valueOf(MAX));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
