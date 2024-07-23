package 动态规划;

import java.util.Arrays;

public class DiffSequence {
    int[][] dp;

    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        dp = new int[tl + 1][sl + 1];
        for (int k = 0; k <= tl; k++) {
            dp[0][k] = 1;
        }
        for (int i = 1; i <= tl; i++) {
            for (int j = 1; j <= sl; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[tl][sl];
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        DiffSequence sequence = new DiffSequence();
        sequence.numDistinct(s, t);
    }

}
