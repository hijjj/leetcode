package huaweiOd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//火星文 good
public class FireStar {
    public void fireStar(String string) {
        Pattern p = Pattern.compile("(\\d+)#(\\d+)");
        while (true) {
            Matcher matcher = p.matcher(string);
            if (matcher.find()) {
                String string1 = matcher.group(0);
                long num1 = Long.valueOf(matcher.group(1));
                long num2 = Long.valueOf(matcher.group(2));
                long calculate = 4 * num1 + 3 * num2 + 2;
                string = string.replaceFirst(string1, String.valueOf(calculate));
            } else {
                break;
            }
        }
        String[] strings = string.split("\\$");
        if(strings.length==1){
            System.out.println(string);
            return;
        }
        Long num1 = Long.valueOf(strings[0]);
        Long num2 = Long.valueOf(strings[1]);
        Long sum = 2 * num1 + num2 + 3;
        for (int i = 2; i < strings.length; i++) {
            sum = 2 * sum + Integer.valueOf(strings[i]) + 3;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();
        FireStar fireStar = new FireStar();
        fireStar.fireStar(line);
    }
}
