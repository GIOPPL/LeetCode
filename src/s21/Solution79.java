package s21;

/**
 * Created by GIOPPL
 * on 2021/7/30 10:39
 * TODO:
 */
public class Solution79 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }


    private static void start() {
        Solution79 s = new Solution79();
        char[][] n1 = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String s1 = "ABFD";
        boolean exist = s.exist(n1, s1);
        System.out.println(exist);
    }

    private int[][] dir = new int[][]{ {0, 1}, {0, -1},{1, 0}, {-1, 0}};
    private boolean[][] v = null;
    private int m;//长
    private int n;//宽

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        //每个节点都遍历一遍，直到有一个匹配的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //每次都要重置v数组
                v = new boolean[m][n];
                boolean isExist=epoch(board,word,0,i,j);
                //只要存在一个数组复合条件，返回true
                if(isExist){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean epoch(char[][] board, String word, int position, int x, int y) {
        //先将该变量设置为已遍历
        v[x][y] = true;
        //如果position的位置出现问题，直接返回false
        if(position <0 || position >= word.length()){
            return false;
        }
        //如果该点的位置和word中位置相匹配，那么直接返回true
        if (position == word.length()-1&&board[x][y]==word.charAt(position)) {
            return true;
        }
        //如果不匹配，返回false
        if(board[x][y] != word.charAt(position)){
            return false;
        }
        //flag的目的是为了标识四个方向是否有一个满足条件，只要有一个满足条件，那么将直接返回true
        int flag=0;
        for (int i = 0; i < dir.length; i++) {
            //转换方向
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && !v[x1][y1]) {
                boolean isExists=epoch(board, word, position + 1, x1, y1);
                if(isExists){
                    flag=1;
                }
                //遍历结束了就要将这个位置的v值设置为没有遍历
                v[x1][y1] = false;
            }
            if(flag==1){
                return true;
            }
        }
        return false;
    }
}
