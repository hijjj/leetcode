package huaweiOd;

import java.util.*;

//最大坐标值 good
public class MaxPostiionValue {
    public void maxPostionValue(int luckyNum, int[] commonds) {
        if(luckyNum==0){
            boolean flag = false;
          for(int i =0;i<commonds.length;i++){
              if(commonds[i]==0){
                  flag=true;
                  break;
              }
          }
          if(flag){
              System.out.println(0);
              return;
          }
        }
        int sum = 0;
        List<Integer> lists = new ArrayList<>();
        lists.add(sum);
        for (int i = 0; i < commonds.length; i++) {
            if (luckyNum == commonds[i]) {
                if (commonds[i] < 0) {
                    sum = sum - (-commonds[i] + 1);
                } else {
                    sum = sum + commonds[i] + 1;
                }
            } else {
                sum = sum + commonds[i];
            }
            lists.add(sum);
        }
        Collections.sort(lists);
        System.out.println(lists.get(lists.size() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String lucky = scanner.nextLine();
        String line = scanner.nextLine();
        int num = Integer.valueOf(nums);
        if (num > 100 || num < 0) {
            System.out.println("12345");
            return;
        }
        int luckys = Integer.valueOf(lucky);
        if (luckys < -100 || luckys > 100) {
            System.out.println("12345");
            return;
        }
        String[] lines = line.split(" ");
        int[] commonds = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            commonds[i] = Integer.valueOf(lines[i]);
            if (commonds[i] > 100 || commonds[i] < -100) {
                System.out.println("12345");
                return;

            }
        }
        MaxPostiionValue maxPostiionValue = new MaxPostiionValue();
        maxPostiionValue.maxPostionValue(Integer.valueOf(lucky), commonds);
    }
}
