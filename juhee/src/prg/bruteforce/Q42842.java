package prg.bruteforce;

public class Q42842 {
    /**
     * 1. 한줄에 노란색 몇개씩 들어가는지 정한 후
     * 2. 갈색의 경우 2 * 노란색 / 한줄에 들어가는 노란색 개수 + 행의 값 * 2 == brown 확인
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int x = 1; x <= yellow; x++) {
            if (yellow % x != 0) continue;
            int w = x + 2;
            int h = (yellow / x) + 2;
            if (w >= h && brown + yellow == w * h) return new int[]{w, h};
        }
        return answer;
    }
}
