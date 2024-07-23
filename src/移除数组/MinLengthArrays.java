package 移除数组;

public class MinLengthArrays {
    int sum = 0;
    int down = 0;
    int result = Integer.MAX_VALUE;

    public int minSubArrayLen(int target, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target) {
                sum -= nums[down];
                result = Math.min(result, i - down + 1);
                down++;
            }
        }

        return result==Integer.MAX_VALUE?0:result;
    }


    public static void main(String[] args) {
        MinLengthArrays minLengthArrays = new MinLengthArrays();
        int[] nums = {2,3,1,2,4,3};
        minLengthArrays.minSubArrayLen(7, nums);
    }
}
