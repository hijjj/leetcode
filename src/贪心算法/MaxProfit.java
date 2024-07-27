package 贪心算法;

public class MaxProfit {
    int[][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        dp[0][0] = 1;
        dp[1][0] = -1;
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]);
    }
}
