package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//幸存数之和 good
public class SumLuckysNumbers {
    public void sumLuckysNumbers(int[] nums, int jumpNumber, int liveNums) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            lists.add(nums[i]);
        }
        int start = 1;
        while (liveNums < lists.size()) {
            start = (start + jumpNumber) % lists.size();
            lists.remove(start);
        }
        int sum = lists.stream().mapToInt(u -> u).sum();

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        SumLuckysNumbers sumLuckysNumbers = new SumLuckysNumbers();
        sumLuckysNumbers.sumLuckysNumbers(nums,num1,num2);
    }
}
