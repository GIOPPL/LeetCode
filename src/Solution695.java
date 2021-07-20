/**
 * 島嶼最大面积
 */
public class Solution695 {
    public static void main(String[] args) {
        long startTime = System.nanoTime(); //获取开始时间
        start();
        long endTime = System.nanoTime(); //获取结束时间
        System.out.print(("程序运行时间：" + (endTime - startTime) / 1000 + "k ns"));
    }

    private static void start() {
        Solution695 s=new Solution695();
        int[][] n1=new int[][]{ {0,0,1,0,0,0,0,1,0,0,0,0,0},
                                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int [][] n2=new int[][]{{1},};
        int x=s.maxAreaOfIsland(n1);
        System.out.println(x);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        //遍历每一个点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //求最大值
                max=Math.max(deepSearch(grid,i,j),max);
            }
        }
        return max;
    }
    public int deepSearch(int[][] grid,int i,int j){
        //保证数组不越界
        if(i<0||i> grid.length-1){
            return 0;
        }
        if (j<0||j>grid[i].length-1){
            return 0;
        }
        //如果为0的话，说明这个地方不是岛屿，直接返回0
        if(grid[i][j]==0){
            return 0;
        }
        //如果是岛屿的话，那么设置这个地方为0，保证下一次不会搜索，沉岛
        grid[i][j]=0;
        //求上下左右的面积
        int b= deepSearch(grid, i-1, j);
        int l= deepSearch(grid, i, j-1);
        int t= deepSearch(grid, i+1, j);
        int r= deepSearch(grid, i, j+1);
        //1为岛屿面积
        return b+l+t+r+1;
    }
}
