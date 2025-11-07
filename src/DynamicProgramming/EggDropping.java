package DynamicProgramming;

public class EggDropping {
    public int eggDrop(int eggs, int floors) {
        int[][] dp = new int[eggs + 1][floors + 1];
        for (int i = 1; i <= eggs; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int j = 1; j <= floors; j++)
            dp[1][j] = j;
        for (int e = 2; e <= eggs; e++) {
            for (int f = 2; f <= floors; f++) {
                dp[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    int res = 1 + Math.max(dp[e - 1][k - 1], dp[e][f - k]);
                    dp[e][f] = Math.min(dp[e][f], res);
                }
            }
        }
        return dp[eggs][floors];
    }

    public static void main(String[] args) {
        EggDropping e = new EggDropping();
        System.out.println(e.eggDrop(2, 10));
    }
}
