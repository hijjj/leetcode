package 移除数组;

import java.util.ArrayList;
import java.util.List;

public class RemoveObjects {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveObjects removeObjects1 = new RemoveObjects();
        int[] nums = new int[]{3,2,2,3};
        removeObjects1.removeElement(nums,2);
    }
}
