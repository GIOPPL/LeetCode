package s21;

import java.util.*;

/**
 * Created by GIOPPL
 * on 2021/7/30 21:58
 * TODO:n皇后问题
 */
public class Solution51 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution51 s = new Solution51();
        List<List<String>> lists = s.solveNQueens(8);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    private List<List<String>> mList;
    //每一列
    private boolean[] col;
    //主对角线
    private boolean[] main;
    //副对角线
    private boolean[] sub;
    //那些位置是Q
    private char[][] board;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        //初始化全为"."
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        col = new boolean[n];
        //主对角线和副对角线大小都为2*n-1
        main = new boolean[2 * n - 1];
        sub = new boolean[2 * n - 1];
        mList = new ArrayList<>();
        dfs(0);
        return mList;

    }

    private void dfs(int row) {
        //如果行号为n，那么说明已经计算完毕
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                l.add(sb.toString());
            }
            mList.add(l);
            return;
        }
        for (int i = 0; i < n; i++) {
            //如果列矩阵，主对角线和副对角线同时不冲突，那么可以赋值
            if (!col[i] && !main[row - i + n - 1] && !sub[row + i]) {
                board[row][i] = 'Q';
                col[i] = true;
                main[row - i + n - 1] = true;
                sub[row + i] = true;
                dfs(row + 1);
                //回溯
                board[row][i] = '.';
                col[i] = false;
                main[row - i + n - 1] = false;
                sub[row + i] = false;
            }
        }
    }
}
