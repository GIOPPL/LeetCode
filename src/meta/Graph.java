package meta;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by GIOPPL
 * on 2021/7/23 8:09
 * TODO:
 */
public class Graph {
    private void DFS(int[][] graph, int x) {
        Stack<Integer> stack = new Stack<>();
        boolean[] v = new boolean[graph.length];
        Arrays.fill(v, false);
        v[x] = true;
        stack.push(x);
        while (!stack.isEmpty()) {
            int top = stack.peek();
            int i;
            for (i = 0; i < graph.length; i++) {
                if (!v[i] && graph[top][i] == 1) {
                    v[i] = true;
                    stack.push(i);
                    break;
                }
            }
            if (i == graph.length) {
                stack.pop();
            }
        }
    }
}
