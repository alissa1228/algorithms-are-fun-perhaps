package prg.queue;
import java.util.*;
/**
 * Q42586. 기능개발
 * 1. 큐에 작업들을 넣어두기 클래스로 만들어서 사용하기
 * 2. 큐에 대하여 loop를 돌며 선행 기능이 개발 되었을 때 몇일이 걸렸는지 확인
 * 3. 해당 기능이 배포 될 때 같이 배포되는 기능에 대하여 탐색
 */
public class Q42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[]{};
        Queue<Job> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) q.offer(new Job(progresses[i], speeds[i]));
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            Job cq = q.poll();
            int cnt = 1;
            int day = (int)Math.ceil((double)(100 - cq.progress) / (double)cq.speed);
            while(!q.isEmpty() && q.peek().progress +  q.peek().speed * day >= 100) {
                q.poll();
                cnt++;
            }
            result.add(cnt);
        }
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    static class Job {
        int progress;
        int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return  "[progress = " + progress + ", speed = " + speed + "]";
        }
    }
}
