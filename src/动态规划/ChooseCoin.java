package 动态规划;

import java.util.Arrays;

/**
 * 重新写
 */

public class ChooseCoin {


    int result[];

    public int coinChange(int[] coins, int amount) {
        result = new int[amount + 1];
        Arrays.fill(result, 6666);
        dp(coins, amount);
        return result[amount];
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] < 0) {
                continue;
            }
            result[amount] = Math.min(dp(coins, amount - coins[i]) + 1, result[amount]);
        }

        return result[amount];
    }

    public static void main(String[] args) {
        ChooseCoin chooseCoin = new ChooseCoin();
        int[] coins = new int[]{1, 2, 5};
        chooseCoin.coinChange(coins, 11);
    }
}
