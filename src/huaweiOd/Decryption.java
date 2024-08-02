package huaweiOd;

import java.util.Scanner;
//密码解密 good
public class Decryption {
    public void decryption(String string) {
        for (int i = 26; i >= 1; i--) {
            String str1 = null;
            String str2 = null;
            if (i <= 9) {
                str1 = i + "";
            } else {
                str1 = i + "*";
            }
            str2 = String.valueOf((char) ('a'+ i - 1 ));
            string = string.replace(str1, str2);
        }
        System.out.println(string);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Decryption decryption = new Decryption();
        decryption.decryption(s);
    }
}
