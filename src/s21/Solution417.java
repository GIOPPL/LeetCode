package s21;

import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/7/23 12:43
 * TODO:
 */
public class Solution417 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution417 s = new Solution417();
        int[][] n1 = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        int[][] n2 = new int[][]{
                {1, 1},
                {1, 1},
                {1, 1},
        };
        int[][] n3 = new int[][]{
                {2, 1},
                {1, 2},
        };
        List<List<Integer>> list = s.pacificAtlantic(n2);
        System.out.println(list.toString());
    }
    //返回答案
    private List<List<Integer>> ans = new ArrayList<>();
    //转换方向用的
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //每一次遍历记录走到的位置
    private boolean[][] temp = null;
    //总的遍历表
    private boolean[][] visit = null;
    //行数
    int m = 0;
    //列数
    int n = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        temp = new boolean[m][n];
        visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //只有没有遍历的从太平洋开始的位置开始
                if (i == 0 || j == 0 && !temp[i][j]) {
                    dfs(heights, i, j, true);
                }
            }
        }
        //记录每一次的遍历记录表初始化
        temp = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //从大西洋开始
                if (i == n-1 || j == m-1 && !temp[i][j]) {
                    dfs(heights, i, j, false);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] graph, int x, int y, boolean isPacific) {
        //如果是从太平洋出发
        if (isPacific) {
            //该点的坐标位置应该设置为已遍历
            visit[x][y] = true;
        }else{
            //如果太平洋中遍历到了同时大西洋遍历到了，那么就是答案
            if(visit[x][y]){
                List<Integer> l=new ArrayList<>();
                l.add(x);
                l.add(y);
                ans.add(l);
                //防止多次加入
                visit[x][y]=false;
            }
        }
        //四个方向挨个遍历
        for (int i = 0; i < dir.length; i++) {
            //更换方向
            int a=x+dir[i][0];
            int b=y+dir[i][1];
            if(a>=0&&a<m&&b>=0&&b<n&&!temp[a][b]&&graph[a][b]>=graph[x][y]){
                //临时表设置为已遍历
                temp[x][y]=true;
                dfs(graph,a,b,isPacific);
            }
        }
    }
}
