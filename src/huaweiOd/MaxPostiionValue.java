package huaweiOd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//最大坐标值
public class MaxPostiionValue {
    public void maxPostionValue(int luckyNum, int[] commonds) {
        int sum =0;
        List<Integer> lists = new ArrayList<>();
        lists.add(sum);
        for (int i = 0; i < commonds.length; i++) {
           if(luckyNum==commonds[i]){
               if(commonds[i]<0){
                   sum=sum-(-commonds[i]+1);
               }else {
                   sum=sum+commonds[i]+1;
               }
           }else {
               sum=sum+commonds[i];
           }
           lists.add(sum);
        }
        Collections.sort(lists);
        System.out.println(lists.get(lists.size()-1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String lucky = scanner.nextLine();
        String line = scanner.nextLine();
        String[] lines = line.split(" ");
        int[] commonds = new int[lines.length];
        for(int i =0 ;i<lines.length;i++){
            commonds[i] =Integer.valueOf(lines[i]);
        }
        MaxPostiionValue maxPostiionValue = new MaxPostiionValue();
        maxPostiionValue.maxPostionValue(Integer.valueOf(lucky),commonds);
    }
}
