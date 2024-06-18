package ltc.string;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1286. Iterator for Combination
 */
public class Q1286 {
    /**
     * 1. 객체 생성 시, DFS로 주어진 combinationLength에 해당하는 조합을 큐에 저장
     * 2. hasNext()의 경우 큐에 남은 조합이 있는지 확인
     * 3. next()의 경우 q.poll()하여 조합에 해당하는 문자를 반환
     */
    int idx;
    int level;
    int length;
    int[] ch;
    String characters;
    Queue<int[]> q;

    public Q1286(String characters, int combinationLength) {
        this.characters = characters;
        this.length = combinationLength;
        this.q = new LinkedList<>();
        this.idx = 0;
        this.ch = new int[combinationLength];
        this.level = 0;
        DFS(0, 0);
    }

    public String next() {
        String result = "";
        int[] comb = q.poll();
        for (int i : comb) result += characters.charAt(i);
        return result;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public void DFS(int L, int D) {
        if (L == length) {
            q.offer(ch.clone());
        } else {
            for (int i = D; i < characters.length(); i++) {
                ch[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
