package 动态规划;

public class ClimbStairs {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        dp[0]=dp[1]=1;
       for(int i=2;i<=n;i++){
           dp[i] =dp[i-1]+dp[i-2];
       }
       return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        climbStairs.climbStairs(2);
    }
}
