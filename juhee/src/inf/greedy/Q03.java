package inf.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 씨름 선수
 */
public class Q03 {
    /**
     * 1. 운동 선수 클래스를 생성. 필드 값으로 키와 몸무게를 선언.
     * 2. 운동 선수 배열을 키 순서로 정렬
     * 3. 이중 for문을 돌면서 해당 선수에 대하여 몸무게가 큰 선수가 있는지 확인.
     * 3. 없을 경우 cnt++하여 선발할 수 있는 최대 선수의 수를 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(stdIn.readLine());
        int answer = 0;
        Athlete[] athletes = new Athlete[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(stdIn.readLine());
            athletes[i] = new Athlete(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(athletes); // 키와 몸무게 순으로 오름차순 정렬
        for (int x = 0; x < n; x++) {
            boolean isSelected = true;
            for (int y = x + 1; y < n; y++) {
                if (athletes[x].weight < athletes[y].weight) { // 해당 운동선수보다 몸무게가 무거을 경우 로직처리
                    isSelected = false;
                    break;
                }
            }
            if (isSelected) answer++;
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static class Athlete implements Comparable<Athlete>{
        int height;
        int weight;

        public Athlete(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        // 키 순으로 정렬 후 같을 경우 몸무게 순으로 정렬
        @Override
        public int compareTo(Athlete a) {
            if (this.height == a.height) {
                return this.weight - a.height;
            } else {
                return this.height - a.height;
            }
        }
    }
}
