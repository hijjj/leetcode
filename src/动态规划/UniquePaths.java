package 动态规划;

import java.util.Arrays;

public class UniquePaths {
    int[][] dp;

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
           return 1;
        }
        dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int k = 0; k < m; k++) {
            dp[k][0] = 1;
        }
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(3, 7);
    }
}
