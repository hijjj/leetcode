package huaweiOd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//字符串筛选 good
public class StringOrder {
    public static void stringOrder(String string, int num) {
        char[] c = string.toCharArray();
        Character[] characters = new Character[c.length];
        for (int i = 0; i < c.length; i++) {
            characters[i] = c[i];
        }
        Comparator<Character> comparator =new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        };
        Arrays.sort(characters,comparator);
        if (c.length <= num) {
            char maxChar = characters[c.length-1];
            for (int i = 0; i < c.length; i++) {
                if (c[i] == maxChar) {
                    System.out.println(i);
                    return;
                }
            }
        } else {
            char c1 = 0;
            for (int i = 0; i < c.length; i++) {
                if ((i + 1) == num) {
                    c1 = characters[i];
                    break;
                }
            }
            for (int j = 0; j < c.length; j++) {
                if (c1 == c[j]) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int num = scanner.nextInt();
        stringOrder(line, num);
    }
}
