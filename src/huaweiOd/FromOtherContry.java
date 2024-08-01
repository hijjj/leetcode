package huaweiOd;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//来自异国的客人 good
public class FromOtherContry {
    public void fromOtherContry(long allMoney, String luckyNum, int numberSystem) {
        String dataStr = convertDateToDigital(numberSystem, allMoney);
        String[] strings = String.valueOf(dataStr).split("");
        List<String> lists = Arrays.asList(strings);
        int sum = 0;
        for (String s : lists) {
            if (s.equals(luckyNum)) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    public String convertDateToDigital(long numberSystem, long allMoney) {
        String result =numberSystem!=16?"":"0x";
        long number = 0;
        long next = 1;
        long currentNumber =allMoney;
        while (next != 0) {
            number = currentNumber % numberSystem;
            next = currentNumber / numberSystem;
            currentNumber=next;
            if (number > 9 && numberSystem == 16) {
                char c = (char) ('A' + number - 10);
                result = result + c;
            } else {
                result = result + number;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FromOtherContry fromOtherContry = new FromOtherContry();
        Scanner scanner = new Scanner(System.in);
        long allmoney = scanner.nextLong();
        int luckyNum= scanner.nextInt();
        int numberSystem=scanner.nextInt();
        fromOtherContry.fromOtherContry(allmoney, String.valueOf(luckyNum), numberSystem);
    }
}
