package huaweiOd;

import java.util.Arrays;
import java.util.Scanner;
//字符串变换最小字符串 good
public class StrChangeMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        strChangeMin(line);
    }

    public static void strChangeMin(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = new char[s.length()];
        StringBuffer stringBuffer = new StringBuffer();
        for (char c1 : chars) {
            stringBuffer.append(c1);
        }
        if (s.equals(stringBuffer.toString())) {
            System.out.println(s);
            return;
        } else {
            int index = 0;
            char tmp;
            char tmp2;
            chars1 = s.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars[i]) {
                    tmp = chars[i];
                    tmp2 = chars1[i];
                    index = findCharIndex(tmp, chars1);
                    chars1[i] = tmp;
                    chars1[index] = tmp2;
                    break;
                }
            }

        }

        StringBuffer stringBuffer1 = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer1.append(chars1[i]);
        }
        System.out.println(stringBuffer1);
    }

    public static int findCharIndex(char target, char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                index = i;
            }
        }
        return index;
    }

}
