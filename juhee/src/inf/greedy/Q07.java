package inf.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 6. 친구인가? (Disjoint-Set : Union&Find)
 */
public class Q07 {
    /**
     * 1. 친구 관계를 나타내는 n+1 길이의 정수 배열 arr을 선언하고 각 인덱스의 값은 인덱스로 할당
     * 2. 친구 관계를 맺는 join 매서드와 해당 인원의 친구를 확인하는 find 매서드를 생성
     * 3. join(int a, int b)의 경우 find(a)와 find(b)의 값이 다를 경우 arr[find(a)]를 find(b)값으로 할당한다.
     * 4-A. find(int n) 매서드의 경우 arr[n]의 값이 n일 경우 n을 반환
     * 4-B. 그 외의 경우 arr[n] = find(arr[n])의 값을 반환한다.
     */
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter stdOut = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(stdIn.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String answer = "YES";
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(stdIn.readLine());
            join(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(stdIn.readLine());
        if (find(Integer.parseInt(st.nextToken())) != find(Integer.parseInt(st.nextToken()))) answer = "NO";
        stdOut.write(answer);
        stdOut.flush();
        stdOut.close();
        stdIn.close();
    }

    static void join(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) arr[fa] = fb;
    }

    static int find(int n) {
        if (arr[n] == n) return n;
        else return arr[n] = find(arr[n]);
    }
}
