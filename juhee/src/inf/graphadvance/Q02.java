package inf.graphadvance;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2. 인접리스트
 */
public class Q02 {
    /**
     * 1. 주어진 모든 경로의 가지수를 인접리스트에 할당
     * 2. DFS를 돌며 5번 정점에 도찰할 때마다 cnt를 증가
     */
    static int N, M, cnt = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];

        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(stdIn.readLine());
            list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        ch[1] = 1;
        DFS(1);

        stdOut.write(String.valueOf(cnt));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static void DFS(int edge) {
        if (edge == N) cnt++;
        else {
            for (int ne : list.get(edge)) {
                if (ch[ne] == 0) {
                    ch[ne] = 1;
                    DFS(ne);
                    ch[ne] = 0;
                }
            }
        }
    }
}
