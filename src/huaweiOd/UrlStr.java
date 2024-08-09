package huaweiOd;

import java.util.Scanner;
//拼接URL 都是抄的需要修改
public class UrlStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replaceFirst("/*,/*", "/");
        System.out.println(s);
    }
}