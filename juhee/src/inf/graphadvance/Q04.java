package inf.graphadvance;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 4. 송아지 찾기(BFS)
 */
public class Q04 {
    static int[] ch = new int[100001], steps = new int[] {-1, 1, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        stdOut.write(String.valueOf(findMyCalf(S, E)));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static int findMyCalf(int S, int E) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        ch[S] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cq = q.poll();
                if (cq == E) return cnt;
                for (int step : steps) {
                    int next = cq + step;
                    if (next < 0 || next > 10000) continue;
                    if (ch[next] != 0) continue;
                    q.offer(next);
                    ch[next] = 1;
                }
            }
            cnt++;
        }
        return -1;
    }
}
