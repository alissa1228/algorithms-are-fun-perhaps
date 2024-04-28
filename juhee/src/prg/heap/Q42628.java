package prg.heap;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 이중우선순위큐: O(N^2)
 */
public class Q42628 {
    static int[] solution(String[] jobs) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String job : jobs) {
            if (job.contains("I")) pq.offer(Integer.parseInt(job.split(" ")[1]));
            else if (job.equals("D 1")) {
                if (!pq.isEmpty()) {
                    PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
                    for (Integer integer : pq) tmp.offer(integer);
                    pq = tmp;
                    pq.poll();
                }
            } else {
                if (!pq.isEmpty()) {
                    PriorityQueue<Integer> tmp = new PriorityQueue<>();
                    for (Integer integer : pq) tmp.offer(integer);
                    pq = tmp;
                    pq.poll();
                }
            }
        }

        if (!pq.isEmpty()) {
            PriorityQueue<Integer> tmp = new PriorityQueue<>(Collections.reverseOrder());
            for (Integer integer : pq) tmp.offer(integer);
            pq = tmp;
            answer[0] = pq.poll();
        }

        if (!pq.isEmpty()) {
            PriorityQueue<Integer> tmp = new PriorityQueue<>();
            for (Integer integer : pq) tmp.offer(integer);
            pq = tmp;
            answer[1] = pq.poll();
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] operation1 = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operation2 = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        stdOut.write(Arrays.toString(solution(operation1)) + "\n");
        stdOut.write(Arrays.toString(solution(operation2)));
        stdOut.flush();
        stdOut.close();
    }
}
