package 贪心算法;

import java.util.ArrayList;
import java.util.List;

public class CanJump {

    boolean[] dp;

    public boolean canJump(int[] nums) {
        dp = new boolean[nums.length];
        if (nums[0] == 0) {
            if (nums.length == 1) {
                return true;
            }
            return false;
        }
        dp[0] = nums[0] != 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                dp[i] = dp[i - 1];
            }

            if (nums[i - 1] == 0) {
                //计算出i-1往前有多少个0
                boolean n = allZero(nums, i - 1);
                if (!n) {
                    dp[i] = false;
                    return false;
                } else {
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public boolean allZero(int[] nums, int i) {
        List<Integer> lists = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            lists.add(nums[j]);
        }
        for (int h = i; h >= 0; h--) {
            if (lists.get(h) > i - h) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        int[] nums = {2,3,1,1,4};
        canJump.canJump(nums);
    }
}
