package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//剩余银饰的重量
public class LastGolden {
    public void lastGolden(List<Integer> nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.size(); i++) {
            queue.add(nums.get(i));
        }

        while (queue.size() >= 3) {
            int max1 = queue.poll();
            int max2 = queue.poll();
            int max3 = queue.poll();
            int remain = (max1 - max2) - (max2 - max3);
            remain = Math.abs(remain);
            if (remain != 0) {
                queue.add(remain);
            }
        }
        if(queue.isEmpty()){
            System.out.println(0);
        }else {
//            System.out.println(queue.size()!=1?queue.poll():Math.abs(queue.poll()));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         int num  = scanner.nextInt();
         List<Integer> lists = new ArrayList<>();
         for(int i=0;i<num;i++){
             lists.add(scanner.nextInt());
         }
         LastGolden l = new LastGolden();
         l.lastGolden(lists);
    }
}
