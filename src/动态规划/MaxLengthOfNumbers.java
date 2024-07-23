package 动态规划;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxLengthOfNumbers {
    int[] results;

    public int lengthOfLIS(int[] nums) {
        results = new int[nums.length];
         pd(nums, nums.length - 1);
         int res=0;
         for(int h=0;h<nums.length;h++){
             res = Math.max(res,results[h]);
         }
         return res;
    }

    public void pd(int[] nums, int i) {
        Arrays.fill(results, 1);
        for (int j = 0; j <= i; j++) {
            for (int k = 0; k < j; k++) {
                if(nums[j]>nums[k]) {
                    results[j] = Math.max(results[j],results[k]+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxLengthOfNumbers maxLengthOfNumbers = new MaxLengthOfNumbers();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        maxLengthOfNumbers.lengthOfLIS(nums);
        System.out.println(maxLengthOfNumbers.results[nums.length - 1]);
    }
}
