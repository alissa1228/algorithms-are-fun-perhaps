package ltc.heap;

import java.util.*;

public class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
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
