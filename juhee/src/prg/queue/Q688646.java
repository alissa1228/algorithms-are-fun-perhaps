package prg.queue;

/**
 * 풍선 터트리기: O(N)
 */
public class Q688646 {
    public int solution(int[] a) {
        int[] leftArr = new int[a.length]; // 각 인덱스의 왼쪽 원소들의 최소값을 저장
        int[] rightArr = new int[a.length]; //각 인덱스의 오른쪽 원소들의 최소값을 저장
        int lt = a[0]; //
        int rt = a[a.length - 1]; //오른쪽 값 중 최소값

        //해당 인덱스 기준 왼쪽의 최소값들을 저장
        for (int i = 1; i < a.length - 1; i++) {
            if (lt > a[i]) lt = a[i];
            leftArr[i] = lt;
        }
        //해당 인덱스 기준 오른쪽의 최소값들을 저장
        for (int i = a.length - 2; i > 0; i--) {
            if (rt > a[i]) rt = a[i];
            rightArr[i] = rt;
        }

        if (a.length == 1) return 1; // 배열의 요소가 1개일 경우 하나이다.

        int answer = 2; // 배열 요소가 2개 이상일 경우 최소 맨 왼쪽, 오른쪽 풍선은 마지막까지 남을 수 있다.
        for (int i = 1; i <= a.length - 2; i++) {
            if (a[i] > leftArr[i] && a[i] > rightArr[i]) continue;
            answer++;
        }
        return answer;
    }
}
