package inf.graphadvance;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 5.섬나라 아일랜드
 */
public class Q05 {
    /**
     * 1. 이차원 배열을 돌며 섬일경우 (board[i][j] == 1)
     * 2. findIsland(int x, int y) 매서드를 호출
     * 3. 해당 매서드는 BFS를 활용하여 해당 좌표와 주변 좌표들이 섬일 경우 바다로 변경함.
     * 4. 해당 매서드가 호출된 횟수를 반환
     */

    static int[] dx = new int[]{-1, 0, 1, 1, 1, 0, -1, -1}, dy = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int answer = 0;
        int N = Integer.parseInt(stdIn.readLine());
        board = new int[N][N];
        for (int x = 0; x < N; x++) {
            st = new StringTokenizer(stdIn.readLine());
            for (int y = 0; y < N; y++) board[x][y] = Integer.parseInt(st.nextToken());
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (board[x][y] == 1) {
                    findIsland(x, y, N);
                    answer++;
                }
            }
        }


        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static void findIsland(int x, int y, int N) {
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(x, y));
        board[x][y] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate nc = q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = nc.x + dx[j];
                    int ny = nc.y + dy[j];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (board[nx][ny] == 0) continue;
                    board[nx][ny] = 0;
                    q.offer(new Coordinate(nx, ny));
                }
            }
        }
    }

    private static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
