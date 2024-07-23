package 二分法;

import java.util.Arrays;

public class SearchInsertPostion {
    int left = 0;
    int right;
    int postion = -1;

    public int searchInsert(int[] nums, int target) {
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                postion = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (postion != -1) {
                break;
            }
        }
        if (postion == -1) {
            int[] newNums = sort(nums, target);
            searchInsert(newNums, target);
        }
        return postion;
    }

    public int[] sort(int[] nums, int target) {

        int[] newNums = new int[nums.length + 1];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        newNums[nums.length]=target;
        Arrays.sort(newNums);

        return newNums;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        SearchInsertPostion searchInsertPostion = new SearchInsertPostion();
        searchInsertPostion.searchInsert(nums, 5);
    }
}
