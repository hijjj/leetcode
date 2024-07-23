package 移除数组;

import java.util.Arrays;

public class SortArrays {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] result = new int[k];

        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                result[k--] = nums[left] * nums[left];
                left++;
            } else {
                result[k--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
