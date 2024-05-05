package prg.heap;

import java.io.*;
import java.util.*;

/**
 * 디스크 컨트롤러: O(logN)
 */
public class Q42627 {
    static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int jobCount = jobs.length, time = 0, workTime = 0;
        PriorityQueue<int[]> rq = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Queue<int[]> wq = new LinkedList<>();
        for (int[] job : jobs) wq.offer(job);
        while (jobCount > 0) {
            while (!wq.isEmpty() && wq.peek()[0] <= time) rq.offer(wq.poll()); // 작업이 도착하였을 경우 readyQueue에 적재
            if (!rq.isEmpty() && rq.peek()[0] <= time) {
                int[] cw = rq.poll();
                workTime += time + cw[1] - cw[0];
                time = time + cw[1];
                jobCount--;
            } else {
                time++;
            }
        }
        answer = workTime / jobs.length;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        stdOut.write(String.valueOf(solution(jobs)));
        stdOut.flush();
        stdOut.close();
    }
}
