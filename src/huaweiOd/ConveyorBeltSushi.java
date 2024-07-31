package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//转盘寿司 good
public class ConveyorBeltSushi {
    public void conveyorBeltSushi(int[] nums) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (num > nums[j]) {
                    int sum = num + nums[j];
                    lists.add(sum);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                boolean flag2 = false;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        flag2 = true;
                        int sum = nums[i] + nums[j];
                        lists.add(sum);
                        break;
                    }
                }
                if (!flag2) {
                    lists.add(nums[i]);
                }
            }
        }
        for (Integer i : lists) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ConveyorBeltSushi conveyorBeltSushi = new ConveyorBeltSushi();
        String[] strs = str.split(" ");
        int[] ints = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.valueOf(strs[i]);
        }
        conveyorBeltSushi.conveyorBeltSushi(ints);
    }
}
