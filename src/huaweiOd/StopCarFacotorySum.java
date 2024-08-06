package huaweiOd;

import java.util.Scanner;
//停车 good需要再进行一次代码清洗，防止代码率不过
public class StopCarFacotorySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

          extracted(sc.nextLine());
    }

    private static void extracted(String sc) {
        String str =
                sc.replaceAll(",", "");
        str =str.replaceAll("111", "x");
        str=str.replaceAll("11", "x");
        str=str .replaceAll("1", "x");

        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                sum++;
            }
        }

        System.out.println(sum);
    }
}