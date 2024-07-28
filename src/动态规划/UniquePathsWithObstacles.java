package 动态规划;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int cloum = obstacleGrid[0].length;
        dp = new int[row][cloum];
        Arrays.fill(dp[0], 1);
        for (int k = 0; k < row; k++) {
            dp[k][0] = 1;
        }
        int flag = 0;
        for (int k = 0; k < row; k++) {
            if (obstacleGrid[k][0] == 1 || flag == 1) {
                dp[k][0] = 0;
                flag = 1;
            }
        }
        int flag2 = 0;
        for (int h = 0; h < cloum; h++) {
            if (obstacleGrid[0][h] == 1 || flag2 == 1) {
                dp[0][h] = 0;
                flag2 = 1;
            }
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[row - 1][cloum - 1] == 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }

        for (int m = 1; m < row; m++) {
            for (int n = 1; n < cloum; n++) {
                if (obstacleGrid[m - 1][n] != 1 && obstacleGrid[m][n - 1] != 1) {
                    dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
                } else if (obstacleGrid[m - 1][n] == 1 && obstacleGrid[m][n - 1] != 1) {
                    dp[m][n] = dp[m][n - 1];
                } else if (obstacleGrid[m][n - 1] == 1 && obstacleGrid[m - 1][n] != 1) {
                    dp[m][n] = dp[m - 1][n];
                } else if (obstacleGrid[m - 1][n] == 1 && obstacleGrid[m][n - 1] == 1) {
                    dp[m][n] = 0;
                }
            }
        }
        return dp[row - 1][cloum - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}};
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        uniquePathsWithObstacles.uniquePathsWithObstacles(nums);
    }
}
