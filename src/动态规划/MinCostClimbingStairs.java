package 动态规划;

public class MinCostClimbingStairs {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int[] cost1 = new int[cost.length-1];
        int k =0;
        for(int i =1;i<cost.length;i++){
            cost1[k]=cost[i];
            k++;
        }
        return Math.min(minCostClimbingStairs1(cost),minCostClimbingStairs2(cost1));
    }
  public int minCostClimbingStairs1(int[] cost){
      dp = new int[cost.length + 1];
      dp[0] = 0;
      dp[1] = dp[0] + cost[0];

      for (int i = 2; i <= cost.length; i++) {
          dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
      }
      return dp[cost.length];
  }
    public int minCostClimbingStairs2(int[] cost){
        dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = dp[0] + cost[0];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
    public static void main(String[] args) {
        MinCostClimbingStairs m =new MinCostClimbingStairs();
        int[] cost = {10,15,20};
        m.minCostClimbingStairs(cost);
    }
}
