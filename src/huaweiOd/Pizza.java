package huaweiOd;

import java.util.Scanner;
// 分pizza good
public class Pizza {
    long[][] result;

    public void pizza(long[] nums) {
        result = new long[nums.length][nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum, getPizzaMax(i - 1 >= 0 ? (i - 1) : nums.length - 1, i + 1 >= nums.length ? 0 : (i + 1), nums)+ nums[i]) ;
        }
        System.out.println(sum);
    }

    public long getPizzaMax(int left, int right, long[] nums) {

        if (nums[left] > nums[right]) {
            left = left - 1>= 0 ? (left - 1) : nums.length - 1;
        } else {
            right = right + 1 >= nums.length ? 0 : (right + 1);
        }
        if (result[left][right] > 0) {
            return result[left][right];
        }
        if (left == right) {
             result[left][right] = nums[left];
        } else {
             result[left][right] = Math.max(getPizzaMax(left - 1>= 0 ? (left - 1) : nums.length - 1, right, nums) + nums[left],
                    getPizzaMax(left, right + 1 >= nums.length ? 0 : (right + 1), nums) + nums[right]
            );
        }
        return result[left][right];
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int num = scanner.nextInt();
        long[] nums = new long[num];
        for(int i = 0; i<num;i++){
            nums[i]=scanner.nextInt();
        }
        Pizza p =new Pizza();
        p.pizza(nums);
    }
}

