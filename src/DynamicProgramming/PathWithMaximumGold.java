package DynamicProgramming;

public class PathWithMaximumGold {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int n, m, max = 0;

    public int getMaximumGold(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] != 0)
                    dfs(grid, i, j, 0);
        return max;
    }

    private void dfs(int[][] grid, int i, int j, int gold) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) return;
        int temp = grid[i][j];
        gold += temp;
        max = Math.max(max, gold);
        grid[i][j] = 0;
        for (int[] d : dir) dfs(grid, i + d[0], j + d[1], gold);
        grid[i][j] = temp;
    }

    public static void main(String[] args) {
        PathWithMaximumGold p = new PathWithMaximumGold();
        int[][] grid = {
                {0,6,0},
                {5,8,7},
                {0,9,0}
        };
        System.out.println(p.getMaximumGold(grid));
    }
}

