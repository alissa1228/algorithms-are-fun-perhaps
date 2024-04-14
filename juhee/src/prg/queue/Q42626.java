package prg.queue;

import java.util.PriorityQueue;

/**
 * 더 맵게: O(NlogN)
 */
public class Q42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(); // heap으로 구성된 priority queue 사용

        for (int i = 0; i < scoville.length; i++) {
            que.offer(scoville[i]);
        }

        while(que.peek() < K) { // Priority Queue는 오름차순으로 요소를 반환함.
            if (que.size() == 1)
                return -1;
            que.offer(que.poll() + que.poll() * 2);
            answer++;
        }
        return answer;
    }
}
