package 贪心算法;

import java.util.Arrays;

public class WiggleMaxLength {
    int[] result;
    int start = 1;
    int k = 0;
    int sum = 0;

    public int wiggleMaxLength(int[] nums) {
        result = new int[nums.length - 1];
        Arrays.fill(result, 0);
        dfs(nums);
        int start = 0;
        int tmp = -2;
        sum = nums.length;
        for (int h = start; h < result.length; h++) {
            if (result[h] == 0) {
                sum--;
            }
            if (tmp == result[h]) {
                sum--;
            }

            tmp = result[h] == 0 ? tmp : result[h];
        }
        return sum;
    }

    public void dfs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = start; j < nums.length; j++) {
                start++;
                if (nums[j] - nums[i] > 0) {
                    result[k] = 1;
                }
                if (nums[j] - nums[i] < 0) {
                    result[k] = -1;
                }
                break;
            }
            k++;
        }

}

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        int[] nums = {3, 3, 3, 2, 5};
        wiggleMaxLength.wiggleMaxLength(nums);
    }
}
