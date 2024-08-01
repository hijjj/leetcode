package huaweiOd;

import java.util.Scanner;

//数的分解 good
public class NumberSplits {
    public void numberSplits(long num) {
        int first = 0;
        for (int i = 2; i <= num; i++) {
            int num2 = (int) (num - ((i - 1) * i / 2));
            if(num2<0){
                break;
            }
            if (num2 % i == 0) {
                first = num2 / i;
                break;
            }
        }
        int sum = 0;
        String str = "";
        if (first == 0) {
            System.out.println("N");
            return;
        } else {
            for (int i = first; ; i++) {
                sum = sum + i;
                str = str + i + "+";
                if (sum == num) {
                   break;
                }
            }
        }
        System.out.println(num + "=" + str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        long num = scanner.nextLong();
        NumberSplits numberSplits = new NumberSplits();
        numberSplits.numberSplits(num);
    }
}
