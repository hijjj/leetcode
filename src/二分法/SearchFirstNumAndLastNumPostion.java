package 二分法;

public class SearchFirstNumAndLastNumPostion {
    int left = 0;
    int right;

    int leftpostion = -1;
    int rightpostion = -1;

    public int[] searchRange(int[] nums, int target) {
        right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
                leftpostion = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        right = nums.length - 1;
        left = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
                rightpostion = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (leftpostion == -1 && rightpostion == -1) {
             return new int[]{-1, -1};
        }else if(leftpostion == -1 || rightpostion == -1){
            return new int[]{mid,mid};
        }else {
            return new int[]{leftpostion,rightpostion};
        }
    }


    public static void main(String[] args) {
        SearchFirstNumAndLastNumPostion searchFirstNumAndLastNumPostion = new SearchFirstNumAndLastNumPostion();
        int[] nums = new int[2];
        nums = new int[]{2, 2};
        searchFirstNumAndLastNumPostion.searchRange(nums, 2);
    }
}
