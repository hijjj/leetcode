package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;
//小明的位置 good
public class XiaoMinFindPostion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lines = scanner.nextLine();
        String[] strings = lines.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        int target = scanner.nextInt();
        xiaoMinFindPostion(nums,target);
    }

    public static void xiaoMinFindPostion(int[] nums, int target) {
        int num = Arrays.binarySearch(nums, target);
        int result = num > 0 ? num + 1 : -(num + 1) + 1;
        System.out.println(result);
    }
}
