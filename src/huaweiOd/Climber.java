package huaweiOd;

import java.util.Scanner;
//爬山 good
public class Climber {
    public void climber(int[] num) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            int left = check(i - 1, num.length, num);
            int right = check(i + 1, num.length, num);
            if (left < num[i] && right < num[i]) {
               count++;
            }
        }
        System.out.println(count);
    }

    public int check(int i, int length, int[] num) {
        if (i < 0 || i >= length) {
            return 0;
        }
        return num[i];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        int[] nums = new int[strings.length];
        for(int i =0;i<nums.length;i++){
            nums[i] = Integer.valueOf(strings[i]);
        }
        Climber climber = new Climber();
        climber.climber(nums);
    }
}
