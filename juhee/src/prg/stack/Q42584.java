package prg.stack;

import java.util.Stack;

/**
 * 주식가격
 */
public class Q42584 {
    /**
     * 큐와 링크드 리스트를 쓴 목적에 대한 고민을 해보기
     * 이중 for문을 돌릴때의 스텍을 사용했을때의 차이를 고민해보기
     * 필요한 기능과 순서 정리
     */

    /**
     * 가격이 떨어지지 않은 기간은 가격이 작은 값이 나올때 결정된다.
     * 1. 인덱스의 가격보다 떨어지는 값이 있는지 stack에서 탐색 => 있을 경우 현재 인덱스 - stack.pop()의 값
     * 2. 해당 인덱스를 stack에 추가
     * 3. loop가 돈 후에도 stack에 남아있는 값(떨어지지 않은 가격)에 대해서는 prices.length() - 1로 값을 할당
     */
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) { // stack 중 가격이 떨어지는지 확인
                int tmp = stack.pop();
                answer[tmp] = i - tmp; // 떨어질 경우 해당 인덱스의 시간 - stack의 시간
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) { // 가격이 떨어진 적이 없는 경우에 대한 처리 로직
            int tmp = stack.pop();
            answer[tmp] = prices.length - tmp - 1;
        }
        return answer;
    }
}
