package huaweiOd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//执行任务赚积分 good
public class DoActionSavePirce {
    public void doActionSavePirce(int time, int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int currentTime = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int endTime = nums[i][0];
            int value = nums[i][1];
            if (currentTime < endTime) {
                priorityQueue.add(value);
                currentTime++;
                sum += value;
            } else {
                if (priorityQueue.isEmpty()) {
                    continue;
                }

                int minValue = priorityQueue.peek();
                if (minValue >= value) {
                } else {
                    priorityQueue.poll();
                    priorityQueue.offer(value);
                    sum += value - minValue;
                }
            }
        }
        int num = priorityQueue.size();
            while (num-time> 0) {
                num--;
                sum -= priorityQueue.poll();
            }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int time = scanner.nextInt();
        int[][] nums = new int[num1][2];
        for (int i = 0; i < num1; i++) {
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            nums[i][0] = num2;
            nums[i][1] = num3;
        }
        DoActionSavePirce doActionSavePirce = new DoActionSavePirce();
        doActionSavePirce.doActionSavePirce(time, nums);
    }
}
