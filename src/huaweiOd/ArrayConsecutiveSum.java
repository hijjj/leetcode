package huaweiOd;

import java.util.Scanner;
// 数组连续和 good
public class ArrayConsecutiveSum {
    public void arrayConsecutiveSum(int target,long[] nums){
       long sum =0;
       int left =0;
       int right =1;
       long[] results = new long[nums.length];
       results[0] =nums[0];
       for(int i =1;i< nums.length;i++){
           results[i] = results[i-1]+nums[i];
       }
       while (right<nums.length){
           if(results[right]-results[left]+nums[left]>=target){
                 sum=sum+nums.length-right;
                 left++;
                 right=left+1;
           }else {
               right++;
           }
       }

       for(int i =0;i<nums.length;i++){
           if(nums[i]>=target){
               sum++;
           }
       }
       System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        long[] nums = new long[num1];
        for(int i =0;i<nums.length;i++){
            nums[i] = scanner.nextInt();
        }
        ArrayConsecutiveSum arrayConsecutiveSum = new ArrayConsecutiveSum();
        arrayConsecutiveSum.arrayConsecutiveSum(num2,nums);
    }
}
