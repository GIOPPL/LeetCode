package test2;

import java.util.ArrayList;
import java.util.LinkedList;

public class BM61 {
    public static void main(String[] args) {
        BM61 bm61 = new BM61();
        var matrix = new int[][]{
                {4, 3, 3, 6, 6, 3, 2, 1, 0, 7},
                {1, 8, 2, 8, 5, 9, 2, 8, 3, 1},
                {8, 0, 9, 2, 4, 3, 2, 4, 3, 7},
                {1, 2, 2, 6, 3, 0, 3, 9, 7, 0},
                {7, 4, 3, 8, 8, 3, 2, 4, 6, 8},
                {2, 8, 9, 2, 9, 3, 0, 8, 7, 8},
                {8, 9, 9, 4, 6, 3, 3, 4, 9, 6},
                {2, 8, 3, 8, 1, 3, 7, 3, 0, 7},
                {2, 1, 1, 6, 4, 1, 0, 8, 1, 6},
                {4, 1, 3, 6, 3, 4, 4, 4, 0, 3}
        };
        var matrix1 = new int[][]{
                {2, 1,},
                {4, 1,}
        };
        System.out.println(bm61.solve(matrix));
    }

    public int solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                fun(matrix, i, j,Integer.MIN_VALUE);
            }
        }
        return re;
    }

    int count = 0;
    int re = 1;

    private void fun(int[][] matrix, int i, int j, int v) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[i].length - 1 || v >= matrix[i][j]) {
            re = Math.max(count, re);
            return;
        }
        if (i - 1 >= 0) {
            count++;
            fun(matrix, i - 1, j, matrix[i][j]);
            count--;
        }
        if (i + 1 < matrix.length) {
            count++;
            fun(matrix, i + 1, j, matrix[i][j]);
            count--;
        }
        if (j - 1 >= 0) {
            count++;
            fun(matrix, i, j - 1, matrix[i][j]);
            count--;
        }
        if (j + 1 < matrix[i].length) {
            count++;
            fun(matrix, i, j + 1, matrix[i][j]);
            count--;
        }

    }

}
