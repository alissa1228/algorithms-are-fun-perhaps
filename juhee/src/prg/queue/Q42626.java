package prg.queue;

import java.util.PriorityQueue;

/**
 * 더 맵게: O(NlogN)
 */
public class Q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            que.offer(scoville[i]);
        }
        while(que.peek() < K) {
            if (que.size() == 1)
                return -1;
            que.offer(que.poll() + que.poll() * 2);
            answer++;
        }
        return answer;
    }
}
