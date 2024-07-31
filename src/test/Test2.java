package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Test2 {
    public void test(int i) {
        i++;
        System.out.println(i);

        test(i);
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String a = scanner.next();
        System.out.println(a);
    }
}
