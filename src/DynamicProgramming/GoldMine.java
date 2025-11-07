package DynamicProgramming;

public class GoldMine {
    public int getMaxGold(int[][] mine) {
        int n = mine.length, m = mine[0].length;
        int[][] dp = new int[n][m];
        for (int col = m - 1; col >= 0; col--) {
            for (int row = 0; row < n; row++) {
                int right = col == m - 1 ? 0 : dp[row][col + 1];
                int rightUp = (row == 0 || col == m - 1) ? 0 : dp[row - 1][col + 1];
                int rightDown = (row == n - 1 || col == m - 1) ? 0 : dp[row + 1][col + 1];
                dp[row][col] = mine[row][col] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }
        int max = dp[0][0];
        for (int i = 1; i < n; i++) max = Math.max(max, dp[i][0]);
        return max;
    }

    public static void main(String[] args) {
        GoldMine g = new GoldMine();
        int[][] mine = {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };
        System.out.println(g.getMaxGold(mine));
    }
}
