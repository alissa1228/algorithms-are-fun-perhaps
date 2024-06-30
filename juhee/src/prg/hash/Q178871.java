package prg.hash;

import java.util.*;

/**
 * 달리기 경주
 */
public class Q178871 {
    /**
     * 1. standings<순서, 이름>, names<이름, 순서>로 이루어진 HashMap 구현
     * 2. 이름이 호명되면 standings에서 해당 선수 순위를 찾고, names<이름, 순서> 추월할 선수의 이름을 찾는다.
     * 3. 그 후 둘의 순서를 바꾸어준다. 이때, map 두개에 모두 순서가 바뀐 것을 적용한다.
     */
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<Integer, String> standings = new HashMap<>();
        Map<String, Integer> names = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            standings.put(i, players[i]);
            names.put(players[i], i);
        }
        for (String calling : callings) {
            int idx = names.get(calling); // 호명된 선수의 순서
            String name = standings.get(idx - 1); // 호명된 선수가 추월할 선수의 이름

            // 순서 바꾸기
            standings.put(idx - 1, calling);
            standings.put(idx, name);
            names.put(calling, idx - 1);
            names.put(name, idx);
        }

        for (int i = 0; i < players.length; i++) answer[i] = standings.get(i);
        return answer;
    }
}
