package huaweiOd;

import java.util.Scanner;

//找座位 good
public class FindSeats {
    public void findSeats(int[] nums) {
        int sum = 0;
        int pre = 0;
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                pre = nums[i - 1];
            }
            if (i + 1 < nums.length) {
                next = nums[i + 1];

            }
            int i1 = nums[i];
            if (i1 != 1 && pre == 0 && next == 0) {
                nums[i] =1;
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lines = scanner.nextLine();
        String[] strings = lines.split("");
        int[] nums = new int[lines.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        FindSeats findSeats = new FindSeats();
        findSeats.findSeats(nums);
    }
}
