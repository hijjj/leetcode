package huaweiOd;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
//悄悄话 good
public class WhisperWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[] nums =new int[strings.length];
        for(int i=0;i< nums.length;i++){
            nums[i] = Integer.valueOf(strings[i]);
        }
        whisperWords(nums);
    }
    public  static void whisperWords(int[] nums) {
        int max = 0;
        int[] result = new int[nums.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        result[0] = nums[0];
        while (!queue.isEmpty()) {
            boolean leftFlag = false;
            boolean rightFlag = false;
            int k = queue.poll();
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            if (left < nums.length && nums[left] != -1) {
                leftFlag = true;
            }
            if (right < nums.length && nums[right] != -1) {
                rightFlag = true;
            }
            if (leftFlag) {
                result[left] =nums[left]+result[k];
                queue.add(left);
            }
            if (rightFlag) {
                result[right]= nums[right]+result[k];
                queue.add(right);
            }
            if (!leftFlag && !rightFlag) {
               max = Math.max(max,result[k]);
            }
        }
      System.out.println(max);
    }

}
