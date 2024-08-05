package huaweiOd;

import java.util.Scanner;
//靠谱的坐车价格 good 先看看之前的写的是不是也是百分之一百
public class CarPirce {
    public void carPrice(int[] nums) {
       int sum =0;
       for(int i =0;i<nums.length;i++){
           if(nums[i]>4){
               nums[i]--;
           }
           for(int j = nums.length-i-1;j>0;j--){
            nums[i]=nums[i]*9;
           }
           sum=sum+nums[i];
       }
       System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numStr = scanner.next().split("");
        int[]  nums = new int[numStr.length];
        for(int i =0;i<nums.length;i++){
            nums[i] = Integer.valueOf(numStr[i]);
        }
        CarPirce carPirce = new CarPirce();
        carPirce.carPrice(nums);
    }
}
