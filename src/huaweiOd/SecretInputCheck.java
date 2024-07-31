package huaweiOd;

import java.util.Scanner;
import java.util.Stack;

//密码输入检测 good
public class SecretInputCheck {
    public void secretInputCheck(char[] c) {
        Stack<Character> stack = new Stack<>();
        boolean hasBigAbc = false;
        boolean hasLittleAbc = false;
        boolean hasNumber = false;
        boolean hasFuHao = false;
        for (int i = 0; i < c.length; i++) {
            char c1 = c[i];
            if ('<' == c[i]) {
                if(!stack.isEmpty()) {
                    stack.pop();
                    continue;
                }else {
                    continue;
                }
            }

            if (c1 >= 'a' && c1 <= 'z') {
                hasLittleAbc = true;
                stack.push(c[i]);
                continue;

            } else if (c1 >= 'A' && c1 <= 'Z') {
                hasBigAbc = true;
                stack.push(c[i]);
                continue;


            } else if (c1 >= '0' && c1 <= '9') {
                hasNumber = true;
                stack.push(c[i]);
                continue;

            }
            stack.push(c[i]);
            hasFuHao = true;
        }
        boolean result = false;

        if (hasBigAbc && hasLittleAbc && hasNumber && hasFuHao) {
            result = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        System.out.println(stringBuffer.reverse() + "," + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] c = string.toCharArray();
        SecretInputCheck secretInputCheck = new SecretInputCheck();
        secretInputCheck.secretInputCheck(c);
    }
}
