package huaweiOd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//整数最小和
public class NumberSumMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int k = scanner.nextInt();
        List<Integer> lists = new ArrayList<>();
        String[] strings1 = str1.split(" ");
        String[] strings2 = str2.split(" ");

        for (int i = 0; i < strings1.length; i++) {
            for (int j = 0; j < strings2.length; j++) {
                lists.add(Integer.valueOf(strings1[i])+Integer.valueOf(strings2[j]));
            }
        }
        NumberSumMin min= new NumberSumMin();
        min.numberSumMin(k,lists);
    }

    public void numberSumMin(int k, List<Integer> sumLists) {
        Collections.sort(sumLists);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + sumLists.get(i);
        }
        System.out.println(sum);
    }
}
