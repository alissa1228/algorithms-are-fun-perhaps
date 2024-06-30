package inf.efficiency;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 6. 모든 아나그램 찾기
 */
public class Q06 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = stdIn.readLine();
        String T = stdIn.readLine();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (Character c : T.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        for (Character c: S.substring(0, T.length()).toCharArray()) sMap.put(c, sMap.getOrDefault(c, 0) + 1);

        int answer = 0;
        if (isAnagram(tMap, sMap)) answer++;
        for (int i = T.length(); i < S.length(); i++) {
            sMap.put(S.charAt(i), sMap.getOrDefault(S.charAt(i), 0) + 1);
            if (sMap.get(S.charAt(i - T.length())) == 1) sMap.remove(S.charAt(i - T.length()));
            else sMap.put(S.charAt(i - T.length()), sMap.getOrDefault(S.charAt(i - T.length()), 0) - 1);
            if (isAnagram(tMap, sMap)) answer++;
        }
        stdOut.write(String.valueOf(answer));
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static boolean isAnagram(Map<Character, Integer> target, Map<Character, Integer> source) {
        if (target.keySet().size() != source.keySet().size()) return false;
        for (Character key : source.keySet()) {
            if (!target.containsKey(key) || !target.get(key).equals(source.get(key))) return false;
        }
        return true;
    }
}
