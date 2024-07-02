package inf.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 4. 가장 높은 탑 쌓기
 */
public class Q04 {
    /**
     * 0. bottom, height, weight를 필드 값으로 가지는 Brick 클래스 구현
     * 1. Brick[] 배열을 생성한 후 입력 값을 저장
     * 2. 이중 for 문을 활용하여 해당 벽돌이 맨 위로 올라갈 수 있는 조합의 최대 높이를 구한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        Brick[] bricks = new Brick[n];
        int[] dy = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            bricks[i] = new Brick(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
//        System.out.println("Arrays.toString(bricks) = " + Arrays.toString(bricks));
        Arrays.sort(bricks);
        dy[0] = bricks[0].height;
        for (int x = 1; x < n; x++) {
            int totalHeight = bricks[x].height;
            for (int y = 0; y <= x - 1; y++) {
                if (bricks[x].weight < bricks[y].weight) {
                    totalHeight = Math.max(totalHeight, dy[y] + bricks[x].height);
                }
            }
            dy[x] = totalHeight;
        }

        stdOut.write(String.valueOf(Arrays.stream(dy).max().getAsInt()));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static class Brick implements Comparable<Brick>{
        int bottom;
        int height;
        int weight;

        public Brick(int bottom, int height, int weight) {
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick b) {
            if (b.bottom == this.bottom) return b.weight - this.weight;
            else return b.bottom - this.bottom;
        }

        @Override
        public String toString() {
            return "[" + bottom + ", " + height + ", " + weight + "]";
        }
    }
}
