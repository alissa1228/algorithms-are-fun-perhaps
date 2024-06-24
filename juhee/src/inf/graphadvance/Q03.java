package inf.graphadvance;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 3. 미로탐색(DFS)
 */
public class Q03 {
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static int[][] board = new int[7][7];
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int j = 0; j < 7; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        board[0][0] = 1;
        DFS(0, 0);
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdIn.close();
        stdIn.close();
    }

    static void DFS(int x, int y) {
        if (x == 6 && y == 6) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 7 || ny >= 7) continue;
                if (board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
}
