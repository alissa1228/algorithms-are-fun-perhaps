package prg.stack;

import java.util.Stack;

/**
 * 올바른 괄호
 */
public class Q12909 {
    /**
     * 1. Stack<Char> 초기화
     * 2. 문자열을 문자 배열로 바꿔주기 (toCharArray())
     * 3. 문자 배열로 돌며 '('일 경우 push()
     * 4. ')'일 경우 stack을 조회함
     * 4-A. stack이 비었을 경우 false 리턴
     * 4-B. stack이 비어있지 않을 경우 pop()
     * 5. 모든 loop가 돈 후 스택이 비어있지 않을 경우 false 리턴
     */
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>(); // 1번 기능 구현
        char[] arr = s.toCharArray(); // 2번 기능 구현
        for (char c : arr) {
            if (c == '(') stack.push(c); // 3번 기능 구현
            else { // (' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때라는 조건이라 else 사용했습니다.
                if (stack.isEmpty()) return false; // 4-A번 기능 구현
                else stack.pop();// 4-B번 기능 구현
            }
        }
        if (!stack.isEmpty()) return false; // 5번 기능 구현
        return answer;
    }
}
