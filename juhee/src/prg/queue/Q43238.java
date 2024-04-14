package prg.queue;

import java.util.Arrays;

/**
 * 입국심사: O(NlogN)
 */
public class Q43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times); // 이분탐색은 정렬된 배열에만 적용가능
        long lt = 0;
        long rt = times[times.length-1] * (long)n; // 제일 긴 대기시간 * 인우너 수
        long answer = rt; // 테스트 케이스의 범위에 따라 자료형을 long으로 설정

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long complete = 0;
            for (int i = 0; i < times.length; i++)
                complete += mid / times[i]; // 각 심사대 별 주어진 시간에 심사할 수 있는 사람의 총계
            if (complete < n) // n보다 적을 경우 더 긴 시간이 필요
                lt = mid + 1;
            else {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }
}
