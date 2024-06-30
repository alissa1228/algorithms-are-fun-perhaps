package ltc.heap;

import java.util.*;

public class MinimumNumberGame {
    public int[] numberGame(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> rpq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) pq.offer(num);
        for (int i = 0; i < nums.length / 2; i++) {
            for (int j = 0; j < 2; j++) if (!pq.isEmpty()) rpq.offer(pq.poll());
            while (!rpq.isEmpty()) list.add(rpq.poll());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
