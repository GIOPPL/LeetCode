package graph;

import java.util.Stack;

/**
 * Created by GIOPPL
 * on 2021/8/17 14:26
 * TODO:
 */
public class InitGraph {
    public static int[][] graph = new int[][]{
            {1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 1, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 1, 1, 1},
            {0, 0, 1, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 1},
    };
    public static int[][] graphPool = new int[][]{
            {1, 1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
    };

    public static int[][] init(int count, int[][] edge, int[] solitaryVector) {
        int[][] graph = new int[count][count];
        for (int[] ints : edge) {
            int p1 = ints[0];
            int p2 = ints[1];
            graph[p1][p2] = 1;
            graph[p2][p1] = 1;
            graph[p1][p1] = 1;
            graph[p2][p2] = 1;
        }
        for (int x : solitaryVector) {
            graph[x][x] = 1;
        }
        return graph;
    }

    public static int[][][] g1() {
        int[][][] list = new int[2][][];
        int[][] edge1 = new int[][]{
                {0, 1}, {0, 2},
                {1, 0}, {1, 3}, {1, 4}, {1, 5},
                {2, 0}, {2, 3}, {2, 6},
                {3, 1}, {3, 4}, {3, 5},
                {4, 1}, {4, 3}, {4, 6},
                {5, 1}, {5, 3}, {5, 6}, {5, 7}, {5, 8},
                {6, 2}, {6, 4}, {6, 5},
                {7, 5},
                {8, 5}
        };
        int[][] edge2 = new int[][]{
                {0, 1}, {1, 4}, {4, 6}
        };
        int[] solitary = new int[]{7, 8};
        int[][] graph = InitGraph.init(9, edge1, new int[]{});
        int[][] graphPool = InitGraph.init(9, edge2, solitary);
        list[0] = graph;
        list[1] = graphPool;
        return list;
    }

    public static int[][][] g2() {
        int[][][] list = new int[2][][];
        //第一个图
        int[][] edge1 = new int[][]{
                {0, 1}, {0, 2},
                {1, 0}, {1, 3},
                {2, 0}, {2, 4},
                {3, 1}, {3, 5}, {3, 6}, {3, 4},
                {4, 3}, {4, 2}, {4, 7}, {4, 8},
                {5, 3},
                {6, 3},
                {7, 4}, {7, 9},
                {8, 4},
                {9, 7}, {9, 10},
                {10, 9}
        };
        //第二个图
        int[][] edge2 = new int[][]{
                {1, 3}, {3, 5}, {2, 4}, {4, 8}
        };
        //独立的点
        int[] solitary = new int[]{10};
        int[][] graph = InitGraph.init(11, edge1, new int[]{});
        int[][] graphPool = InitGraph.init(11, edge2, solitary);
        list[0] = graph;
        list[1] = graphPool;
        visitGraph(graph);
        visitGraph(graphPool);
        return list;
    }

    public static void visitGraph(int[][] graph) {
        System.out.println("======开始遍历图========");
        boolean[] v=new boolean[graph.length];
        boolean connected=true;
        int c=0;
        for (int i = 0; i < graph.length; i++) {
            if(!v[i]&&graph[i][i]!=0){
                dfs(graph,i,v);
                if(c==0){
                    for (int j = 0; j < graph.length; j++) {
                        if (!v[j]) {
                            connected = false;
                            break;
                        }
                    }
                    c=1;
                }
            }
        }
//        if(connected){
//            System.out.println("该图是连通图");
//        }else {
//            System.out.println("该图不是连通图");
//        }
        System.out.println();
    }

    private static void dfs(int[][] graph, int v, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        visited[v] = true;
        System.out.print(v + ",");
        stack.push(v);
        while (!stack.empty()) {
            int j = stack.pop();
            int i;
            for (i = 0; i < graph.length; i++) {
                if (graph[j][i] != 0 && !visited[i]) {
                    System.out.print(i + ",");
                    visited[i] = true;
                    stack.push(i);
                    break;
                }
            }
            if (i == graph.length && !stack.empty()) {
                stack.pop();
            }
        }
    }
}
