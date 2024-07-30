package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumNumber {
    public void printNumbers(int n) {
        int sum = 0;
        List<List<Integer>> list2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = i;
            List<Integer> lists = new ArrayList<>();
            while (sum < n) {
                lists.add(a);
                sum = a + sum;
                if(sum==n){
                    break;
                }
                a++;
            }

            if(sum==n){
                list2.add(lists);
            }
            sum=0;

        }
        for (int j = list2.size() - 1; j >= 0; j--) {
            List<Integer> lists3 = list2.get(j);
            String result = "";
            for (Integer i : lists3) {
                result = result  + i+"+";
            }
            System.out.println(n+"="+result.substring(0,result.length()-1));
        }
        System.out.println("Result:"+list2.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer num = scanner.nextInt();
        SumNumber sumNumber = new SumNumber();
        sumNumber.printNumbers(num);
    }
}
