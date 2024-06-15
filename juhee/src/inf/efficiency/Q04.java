package inf.efficiency;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 4. 학급 회장(해쉬)
 */
public class Q04 {
    /**
     * 1. 매 투표용지마다 Map<Character, Integer>를 활용하여 개표내역을 저장한다.
     * 2. map.getOrDefault()를 활용하여 없는 경우 0을 있는 경우 해당 key에 대한 value + 1 값을 저장한다.
     * 3. 모든 keySet()에 대하여 loop를 돌며 최다 득표자를 확인한다.
     * 4. 반드시 한명이 나온다고 하였기에 동률의 경우는 생략한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(stdIn.readLine());
        String votes = stdIn.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (char vote : votes.toCharArray()) map.put(vote, map.getOrDefault(vote, 0) + 1);
        int max = Integer.MIN_VALUE;
        Character answer = null;
        for (Character key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        if (answer != null)stdOut.write(Character.toString(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
