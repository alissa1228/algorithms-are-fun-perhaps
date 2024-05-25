package ltc.heap;

import java.util.*;

public class SmallestInfiniteSet {
    // 최소값 탐색을 위한 PriorityQueue 초기화
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 중복 검증을 위한 Set 초기화
    Set<Integer> set = new HashSet();
    public SmallestInfiniteSet() {
        for (int i = 1; i <= 100 ;i++) {
            pq.offer(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        int smallest = pq.poll();
        set.remove(smallest);
        return smallest;
    }

    public void addBack(int num) {
        if (!set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
    }
}
