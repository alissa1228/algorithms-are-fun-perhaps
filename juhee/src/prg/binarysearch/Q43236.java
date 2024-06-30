package prg.binarysearch;

import java.util.Arrays;

/**
 * Q43236. 징검다리
 */
public class Q43236 {
    /**
     * 0. 시작점과 도착점을 배열에 추가
     * 1. 0과 distance를 각각 lt와 rt로 설정하여 n개의 돌을 뺐을 때의 돌들 간의 최대 거리를 설정
     * 2. 이전 돌들이 연속하여 건너뛴 경우를 반영하기 위하여 extraGap변수 활용
     * 3. 배열에 loop를 돌며 해당 돌과 전 돌과의 거리가 mid보다 작을 경우 카운트와 연속하여 건너뛴 횟수 증가
     * 4. 만약 n번 이상 돌을 건너 뛰었다면 반복문을 종료
     * 5. 건너뛴 횟수가 n번 이하일 경우 최대 거리를 더 크게 설정
     * 6. 초과일 경우 해당 거리를 더 작게 설정
     */
    public int solution(int distance, int[] rocks, int n) {
        int[] arr = new int[rocks.length + 2];
        arr[0] = 0;
        for (int i = 1; i < arr.length - 1; i++) arr[i] = rocks[i - 1];
        arr[arr.length - 1] = distance;
        int answer = 0, lt = 0, rt = distance, len = arr.length;
        Arrays.sort(arr);
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 0, extraGap = 0;
            for (int i = 1; i < len; i++) {
                int gap = arr[i] - arr[i - 1 - extraGap];;
                if (gap < mid) {
                    cnt++;
                    extraGap += 1;
                } else extraGap = 0;

                if (cnt > n) break;
            }
            if (cnt <= n) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }
}
