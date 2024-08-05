package huaweiOd;

import java.util.Scanner;

//停车场位置
public class StopCarFacotorySum {
    public void stopCarFactorySum(String string) {
        int res = 0;
        String[] strings = string.split("0");
        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();
            if (length == 0) {
                continue;
            }
            if (length % 3 == 0) {
                res = res + (length / 3);
            } else {
                res = res + (length / 3) + 1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        StopCarFacotorySum sum1= new StopCarFacotorySum();
        Scanner scanner = new Scanner(System.in);
        sum1.stopCarFactorySum(scanner.nextLine());
    }
}
