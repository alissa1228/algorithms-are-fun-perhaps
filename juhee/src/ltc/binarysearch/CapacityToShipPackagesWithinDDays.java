package ltc.binarysearch;

import java.util.Arrays;

/**
 * 1011. Capacity To Ship Packages Within D Days
 */
public class CapacityToShipPackagesWithinDDays {
    /**
     * 1. 가장 무거운 화물의 무게 ~ 모든 화물 무게의 총합을 탐색 범위로 설정
     * 2. 한번에 적재할 수 있는 무게로 적재할 때 걸리는 일수를 days와 비교하며 탐색 범위를 조정
     */
    public int shipWithinDays(int[] weights, int days) {
        int lt = Arrays.stream(weights).max().getAsInt(), rt = Arrays.stream(weights).sum(), answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2, sum = 0, cnt = 0;
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] == mid) {
                    cnt++;
                    if (sum != 0) cnt++;
                    sum = 0;
                } else {
                    sum += weights[i];
                    if (sum >= mid) {
                        cnt++;
                        if (sum == mid) sum = 0;
                        else sum = weights[i];
                    }
                }
            }
            if (sum != 0) cnt++;
            if (cnt <= days) {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            } else lt = mid + 1;
        }
        return answer;
    }
}
