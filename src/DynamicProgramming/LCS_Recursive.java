package DynamicProgramming;

public class LCS_Recursive {
    public int lcs(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return 1 + lcs(s1, s2, i - 1, j - 1);
        else
            return Math.max(lcs(s1, s2, i - 1, j), lcs(s1, s2, i, j - 1));
    }

    public static void main(String[] args) {
        LCS_Recursive l = new LCS_Recursive();
        String s1 = "abcde", s2 = "ace";
        System.out.println(l.lcs(s1, s2, s1.length(), s2.length()));
    }
}
