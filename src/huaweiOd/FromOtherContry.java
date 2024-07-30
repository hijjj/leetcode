package huaweiOd;

import java.util.Arrays;
import java.util.List;

//来自异国的客人
public class FromOtherContry {
    public void fromOtherContry(int allMoney, String luckyNum, int numberSystem) {
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

    public String convertDateToDigital(int numberSystem, int allMoney) {
        String result =numberSystem!=16?"":"0x";
        int number = 0;
        int next = 1;
        int currentNumber =allMoney;
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
        fromOtherContry.fromOtherContry(15, "1", 16);
    }
}
