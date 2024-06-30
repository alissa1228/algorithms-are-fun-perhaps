package prg.bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 42839. 소수 찾기
 */
public class Q42839 {
    /**
     * 1. DFS를 활용하여 발생할 수 있는 모든 수의 조합에 대하여 소수인지 확인
     * 2. 소수일 경우 cnt 증가
     * 3. 중복 카운트를 방지하기 위하여 Set을 활용
     */
    static int N, answer, LENGTH = 10000000;
    static boolean[] isPrime = new boolean[LENGTH + 1]; // 소수 여부를 확인할 배열
    static int[] ch;
    static char[] chars, arr;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        answer = 0;
        N = numbers.length();
        ch = new int[N];
        arr = new char[N];
        chars = numbers.toCharArray();
        findNp();
        for (int i = 1; i <= N; i++) {
            DFS(0, i);
        }
        return answer;
    }

    static void findNp() {
        // 배열의 모든 원소를 true로 할당
        Arrays.fill(isPrime, true);
        // 0과 1은 소수가 아님으로 false로 할당
        isPrime[0] = isPrime[1] = false;
        // n의 모든 약수에 해당하는 약수들은 Math.sqrt(Length) 이하의 숫자이기 때문에 범위를 아래와 같이 정하였다.
        for (int x = 2; x <= Math.sqrt(LENGTH); x++) {
            if (isPrime[x] == true) { // 해당 수가 소수일 경우
                // 해당 소수의 제곱수 ~ LENGTH까지의 모든 숫자 중 해당 소수의 배수에 대하여 false로 할당.
                for (int y = (int) Math.pow(x, 2); y <= LENGTH; y += x) isPrime[y] = false;
            }
        }
    }

    static void DFS(int L, int M) {
        if (L == M) {
            // 조합에 대한 문자 배열을 숫자로 치환하는 로직
            String str = "";
            for (int i = 0; i < M; i++) str += arr[i];
            int tmp = Integer.parseInt(str);

            // 이미 확인한 수일 경우 건너뛴다.
            if (set.contains(tmp)) return;
            // 소수일 경우 answer을 1 증가시킨다.
            if (isPrime[tmp]) {
                set.add(tmp);
                answer++;
            }
        } else {
            for (int i = 0; i < N; i++) {
                // 만약 사용하지 않은 숫자일 경우 해당 자리(L)에 할당한다.
                if (ch[i] == 0) {
                    ch[i] = 1;
                    arr[L] = chars[i];
                    DFS(L + 1, M);
                    ch[i] = 0;
                }
            }
        }
    }
}
