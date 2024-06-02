package ltc.graph;

import java.util.*;

public class AllPathFromSourceToTarget {
    static int n;
    static int[] ch;
    static List<List<Integer>> answer;
    static void DFS(int[][] graph, int v, Stack<Integer> stack) {
        if (v == n) {
            answer.add(new ArrayList<>(stack));
        } else {
            for (int nv : graph[v]) {
                stack.push(nv);
                DFS(graph, nv, stack);
                stack.pop();
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length - 1;
        answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        DFS(graph, 0, stack);
        return answer;
    }
}
