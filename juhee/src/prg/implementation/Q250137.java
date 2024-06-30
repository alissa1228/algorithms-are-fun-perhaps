package prg.implementation;

import java.io.*;
import java.util.*;

/**
 * [PCCP 기출문제] 1번 / 붕대 감기
 */
public class Q250137 {
    /**
     * 1. 0초 ~ 마지막 공격 시간까지 LOOP
     * 2. 공격이 있을 경우 체력 감소, 체력이 0보다 작을 경우 -1 바환
     * 3. 공격이 없을 경우 bandage 성능에 따라 체력 증가
     * 4. 연속 성공 카운트 증가, 최대 연속 횟수 도달 시 추가 체력 증가
     * 5. 최대 체력 도달 시에는 체력 증가
     */
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int max = Arrays.stream(attacks)          // 이차원 배열을 스트림으로 변환
                .mapToInt(arr -> arr[0]) // 각 배열의 첫 번째 값을 추출
                .max()                   // 최대 값 찾기
                .orElseThrow();
        PriorityQueue<Attack> pq = new PriorityQueue<>();
        for (int[] a : attacks) pq.offer(new Attack(a[0], a[1]));
        System.out.println(pq);
        int cnt = 0;
        for (int i = 1; i <= max; i++) {
            // 공격을 받는 경우
            if (pq.peek().time == i) {
                answer -= pq.poll().damage; // 데미지만큼 체력 감소
                if (answer <= 0) return -1; // 체력이 0 이하일 경우 -1 반환
                cnt = 0; // 연속 기술 카운트롤 0으로 초기화
            } else {
                answer += bandage[1]; // 초당 회복량 만큼 회복
                cnt++; // 연속 성공 횟수 증가
                // 시전 시간만큼 연속 성공 시 추가 체력 증가 후 연속 기술 카운트 초기화
                if (cnt == bandage[0]) {
                    answer += bandage[2];
                    cnt = 0;
                }
                // 최대 체력 이상으로 회복했을 경우 최대 체력으로 유지
                if (answer >= health) answer = health;
            }
        }
        return answer;
    }

    static class Attack implements Comparable<Attack>{
        int time;
        int damage;

        public Attack(int time, int damage) {
            this.time = time;
            this.damage = damage;
        }

        @Override
        public int compareTo(Attack a) {
            if (this.time == a.time) return this.damage - a.damage;
            else return this.time - a.time;
        }

        @Override
        public String toString() {
            return "[time = " + time + ", damage = " + damage + "]";
        }
    }
}
