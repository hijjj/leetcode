package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//分割字符串
public class SplitString {
    public void splitString(char[] strs) {
        List<String> lists = new ArrayList<>();
        int xNum = 0;
        int yNum = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == 'X') {
                xNum++;
            } else {
                yNum++;
            }
            String string = "";
            if (xNum == yNum) {
                for (int j = 0; j < xNum; j++) {
                    string = string + strs[j];
                }
                lists.add(string);
                xNum = 0;
                yNum = 0;
            }
        }
        System.out.println(lists.size());

    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        String string1 = "";
        for (int i = 0; i < 10000; i++) {
            string1 = string1 + "XY";
        }
        String[] strings = string1.split("");
        char[] chars = new char[strings.length];
        for (int i = 0; i < chars.length; i++) {
            String s = strings[i];
            chars[i] = s.charAt(0);
        }
        SplitString string = new SplitString();
        string.splitString(chars);

    }
}
