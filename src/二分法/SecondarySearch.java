package 二分法;

public class SecondarySearch {
    int left = 0;
    int right;

    public int search(int[] nums, int target) {
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if(nums[mid]<target){
                 left=mid+1;
            }else {
                right =mid-1;
            }
        }
        return -1;
    }
}
