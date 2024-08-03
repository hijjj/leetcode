package huaweiOd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//求字符串中所有整数的最小和 good
public class NumberInStrMin {
    public static void numberInStrMin(String string) {
        BigInteger sum = new BigInteger("0");
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(string);
        List<BigInteger> lists = new ArrayList<>();
        while (m.find()) {
            lists.add(new BigInteger(m.group()));
        }
        if (lists.size() == 1 && lists.get(0).compareTo(new BigInteger("0"))<0) {
            System.out.println(lists.get(0));
            return;
        } else {
            for (BigInteger i : lists) {
                if (i .compareTo(new BigInteger("0"))<0) {
                 sum=sum.add(i);
                }else {
                    String[] s = String.valueOf(i).split("");
                    for(String string1:s){
                        sum =sum.add(new BigInteger(string1));
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        numberInStrMin(string);
    }
}
