package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubArray {
    int[] dp;

    public int maxSubArray(int[] nums) {
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        List<Integer> results = new ArrayList<>();
        for(int j=0;j<dp.length;j++){
            results.add(dp[j]);
        }
        Collections.sort(results);
        return  results.get(dp.length-1);
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray.maxSubArray(nums);
    }
}
