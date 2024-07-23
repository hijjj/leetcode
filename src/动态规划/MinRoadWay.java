package 动态规划;

public class MinRoadWay {
    public int minPathSum(int[][] grid) {
        int heng = grid.length;
        int shu = grid[0].length;
        return dp(grid, heng-1, shu-1);
    }


    public int dp(int[][] grid, int j, int i) {
        if (j == 0 && i == 0) {
            return grid[0][0];
        }

        if (j < 0 || i < 0) {
            return Integer.MAX_VALUE;
        }
        return Math.min(dp(grid, j - 1, i), dp(grid, j, i - 1)) + grid[j][i];
    }
}
