package DynamicProgramming;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++)
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);
                if (pc == '.' || pc == sc)
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pc == '*')
                    dp[i][j] = dp[i][j - 2] || ((p.charAt(j - 2) == '.' || p.charAt(j - 2) == sc) && dp[i - 1][j]);
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        System.out.println(r.isMatch("aab", "c*a*b"));
    }
}
