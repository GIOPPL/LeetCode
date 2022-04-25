package test2;

public class DFS {
    public static void main(String[] args) {
        int[][] island = new int[][]{
                {0, 0, 0, 0, 1},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0}
        };
        boolean[] visited = new boolean[island.length];
        for (int i = 0; i < island.length; i++) {
            if (!visited[i]){
                dfs(island, i, visited);
            }
        }

    }

    private static void dfs(int[][] lands, int i, boolean[] visited) {
        visited[i] = true;
        System.out.println(i);
        for (int j = 0; j < lands.length; j++) {
            if (!visited[j] && lands[i][j] == 1) {
                dfs(lands, j, visited);
            }
        }
    }
}
