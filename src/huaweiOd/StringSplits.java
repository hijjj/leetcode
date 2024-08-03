package huaweiOd;

import java.util.Scanner;

//字符串分割(二) good
public class StringSplits {
    public static void stringSplits(String string, int num) {
        String[] strings = string.split("-");
        String first = strings[0];
        String next = "";
        for (int j = 1; j < strings.length; j++) {
            next = next + strings[j];
        }
        StringBuffer stringBuffer = new StringBuffer(first);
        stringBuffer.append("-");
        int lengths = next.length();
        int n = lengths / num;
        if (lengths % num != 0) {
            n = n + 1;
        }
        for (int j = 0; j < n; j++) {
            String sonStr = "";
            int endIndex = num * (j + 1);
            if (endIndex > next.length()) {
                sonStr = change(next.substring(j * num)) + "-";
            } else {
                sonStr = change(next.substring(j * num, endIndex)) + "-";
            }
            stringBuffer.append(sonStr);
        }

        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
    }

    private static String change(String next) {
        //字母大小判断
        int little = 0;
        int big = 0;
        char[] c = next.toCharArray();
        for (char c1 : c) {
            if (c1 >= 'a' && c1 <= 'z') {
                little++;
            }
            if (c1 >= 'A' && c1 <= 'Z') {
                big++;
            }
        }

        boolean convertToBig = little < big;
        String newStr = "";
        for (char c1 : c) {
            if (little != big) {

                if (checkAbc(c1)) {
                    if (convertToBig && c1 >= 'a' && c1 <= 'z') {
                        c1 = (char) (c1 - ('a' - 'A'));
                    } else if (!convertToBig && c1 >= 'A' && c1 <= 'Z') {
                        c1 = (char) (c1 + ('a' - 'A'));
                    }
                }
            }
            newStr = newStr + c1;
        }
        return newStr;
    }

    public static boolean checkAbc(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String line = scanner.next();
        stringSplits(line, num);
    }
}
