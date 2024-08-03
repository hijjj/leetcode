package huaweiOd;

import java.util.*;
import java.util.stream.Collectors;
//英文输入法 good
public class EnglishInput {
    public static void englishInput(String string, String pre) {
        String[] strings = string.split(" ");
        int length = pre.length();
        List<String> lists = new ArrayList<>();
        for (String s : strings) {
            String[] s1 = s.split("'");
            String[] s2 = s.split("\"");
            String[] s3 = s.split("-");
            int maxLength = Math.max(s1.length, s2.length);
            maxLength = Math.max(maxLength, s3.length);
            if (maxLength == s2.length) {
                s1 = s2;
            } else if (maxLength == s3.length) {
                s1 = s3;
            }
            for (String string1 : s1) {
                String newStr = string1.length()>=length?string1.substring(0, length):string1.substring(0);
                if (newStr.equals(pre)) {
                    lists.add(string1);
                }
            }
        }
        if (lists.isEmpty()) {
            lists.add(pre);
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] c1 = o1.toCharArray();
                char[] c2 = o2.toCharArray();
                int num1 = c1.length;
                int num2 = c2.length;
                int min = Math.min(num2,num1);
                    for (int i = 0; i < min; i++) {
                         if(c1[i]!=c2[i]) {
                             return c1[i] - c2[i];
                         }
                }
                return num1-num2;
            }
        };
        Collections.sort(lists,comparator);
        System.out.println(lists.stream().distinct().collect(Collectors.joining(" ")));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        englishInput(line1, line2);
    }
}
