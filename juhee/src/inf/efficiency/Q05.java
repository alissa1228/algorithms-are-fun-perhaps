package inf.efficiency;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 5. 아나그램(해쉬)
 */
public class Q05 {
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = stdIn.readLine();
        String str2 = stdIn.readLine();
        String answer = "YES";

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (Character c : str1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
        for (Character c : str2.toCharArray()) map2.put(c, map2.getOrDefault(c, 0) + 1);

        for (Character key : map1.keySet()) {
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) {
                answer = "NO";
                break;
            }
        }
        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }
}
