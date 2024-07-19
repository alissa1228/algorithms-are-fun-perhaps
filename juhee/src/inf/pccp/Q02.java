package inf.pccp;
import java.util.*;

class Q02 {
	/**
	 * 1. land에 대하여 복사값을 만든 후 유전인 곳은 해당 유전의 총 개수로 저장
	 * 2. 각 열별로 돌면서 시추할 수 있는 값을 구한다
	 * 3. 이때 열의 첫번째 값을 colCnt의 값으로 할당
	 * 4. 1번 인덱스 부터 돌며, 해당 인덱스가 1이고 전 인덱스가 0일때 해당 인덱스의 값을 더해준다.
	 */
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
	static Map<Integer, Integer> map = new HashMap<>();
	public int solution(int[][] land) {
		int answer = 0;
		markLand(land);
		for (int i = 0; i < land[0].length; i++) {
			int tmp = 0;
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < land.length; j++) {
				set.add(land[j][i]);
			}
			for (Integer key : set) tmp += map.getOrDefault(key, 0);
			answer = Math.max(answer, tmp);
		}
		return answer;
	}

	public void markLand(int[][] land) {
		int markNum = 2;
		for (int x = 0; x < land.length; x++) {
			for (int y = 0; y < land[0].length; y++) {
				if (land[x][y] == 1) {
					Queue<Coordinate> q = new LinkedList<>();
					q.offer(new Coordinate(x, y));
					land[x][y] = markNum;
					int tmp = 1;
					while (!q.isEmpty()) {
						int size = q.size();
						for (int k = 0; k < size; k++) {
							Coordinate cq = q.poll();
							for (int l = 0; l < 4; l++) {
								int nx = cq.x + dx[l];
								int ny = cq.y + dy[l];
								if (nx >= 0 && nx < land.length
										&& ny >= 0 && ny < land[0].length && land[nx][ny] == 1) {
									q.offer(new Coordinate(nx, ny));
									land[nx][ny] = markNum;
									tmp++;
								}
							}
						}
					}
					map.put(markNum++, tmp);
				}
			}
		}
	}

	static class Coordinate{
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}