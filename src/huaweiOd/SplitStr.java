package huaweiOd;

import java.util.Scanner;

public class SplitStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int countX = 0;
        int countY = 0;

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                countX++;
            } else {
                countY++;
            }

            if (countX == countY) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}