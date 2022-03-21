package s21;

import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/7/18 10:50
 * TODO:
 */
public class Solution547 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        int[][] n1 = new int[][]{
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1},
        };
        Solution547 s = new Solution547();
        int num = s.findCircleNum(n1);
        System.out.println("count:"+num);
    }

    public int findCircleNum(int[][] isConnected) {
        int count=0;
        //是否查验过的数组
        boolean[] visit=new boolean[isConnected.length];
        Arrays.fill(visit,false);
        //将自链接去除
        for (int i = 0; i < isConnected.length; i++) {
            isConnected[i][i] = 0;
        }
        for (int i = 0; i < isConnected.length; i++) {
            //如果没有查验，就可以从这个节点开始
            if(!visit[i]){
                //返回本次查验的数组
                boolean[] v = visitGraph(isConnected, i);
                for (int j = 0; j < v.length; j++) {
                    //只有当这个城市没有查验，才可以设置数组，也就是查验过了就直接通过
                    if (!visit[j]) {
                        visit[j] = v[j];
                    }
                }
                //每次查验身份数量+1
                count++;
            }
        }

        return count;
    }

    private boolean[] visitGraph(int[][] graph, int x) {
        System.out.println(x);
        Stack<Integer> stack = new Stack<>();
        boolean[] v = new boolean[graph.length];
        Arrays.fill(v, false);
        v[x] = true;
        stack.push(x);
        while (!stack.isEmpty()) {
            //查看最顶上的
            int top = stack.peek();
            int i;
            for (i = 0; i < graph.length; i++) {
                //只要看到可以遍历的
                if (!v[i] && graph[top][i] == 1) {
                    v[i] = true;
                    //吞一个
                    stack.push(i);
                    System.out.println(i);
                    break;
                }
            }
            //这一行运行到最后都没有找到一个没遍历过的，那么就吐一个
            if (i == graph.length) {
                stack.pop();
            }
        }
        return v;
    }
}
