package huaweiOd;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//提取字符串中的最长合法简单数学表达式 抄的需要修改
public class GetMaxLengthStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        // 下面正则可得90%+通过率, 可以继续尝试下 r"([+-]?\d+)([+*-])(\d+)" 的通过率
        Pattern compile = Pattern.compile("(-?\\d+)([+*-])(\\d+)");

        int maxExpLen = 0;
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {

            // 本题有大数量级用例，因此需要此步优化，不然通过率不高
            if(s.length() - i <= maxExpLen) {
                break;
            }

            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);

                Matcher matcher = compile.matcher(sub);

                if (matcher.find() && sub.length() > maxExpLen) {
                    maxExpLen = sub.length();

                    long op_num1 = Long.parseLong(matcher.group(1));
                    String op = matcher.group(2);
                    long op_num2 = Long.parseLong(matcher.group(3));

                    switch (op) {
                        case "*":
                            ans = op_num1 * op_num2;
                            break;
                        case "+":
                            ans = op_num1 + op_num2;
                            break;
                        case "-":
                            ans = op_num1 - op_num2;
                            break;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}