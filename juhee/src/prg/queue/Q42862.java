package prg.queue;

import java.util.Arrays;

/**
 * 체육복: O(N^2)
 */
public class Q42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(reserve);
        Arrays.sort(lost);

        // 수업 참여가 가능한 학생 수의 최소값 = 전체 학생 수 - 도난당한 학생 수
        answer = n - lost.length;

        // 도난 당했지만, 여벌의 체육복이 있는 학생
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    // 해당 학생에 대한 값을 -1로 할당하여 중복 제거
                    lost[i] = -1;
                    reserve[j] = -1;
                    // 여벌의 옷을 사용하였다면 break
                    break;
                }
            }
        }

        // 체육복을 도난당했지만 빌릴 수 있는 학생 => 기존에 여벌의 체육복이 사용된 경우 -1처리 됐기에 중복 X
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    // 해당 학생에 대한 값을 -1로 할당하여 중복 제거
                    reserve[j] = -1;
                    // 빌렸다면 break
                    break;
                }
            }
        }

        return answer;
    }
}
