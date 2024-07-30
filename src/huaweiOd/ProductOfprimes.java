package huaweiOd;

import java.util.Scanner;
//素数乘机
public class ProductOfprimes {
    public void productOfprimes(int num) {
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                boolean result1 = checkNumber(i);
                boolean result2 = checkNumber(num / i);
                if (result1 && result2) {
                    if (i >= (num / i)) {
                        System.out.println(num / i + " " + i);
                        return;
                    } else {
                        System.out.println(i + " " + num / i);
                        return;
                    }
                }
            }

        }
        System.out.println("-1" + " " + "-1");
    }

    public boolean checkNumber(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        ProductOfprimes productOfprimes = new ProductOfprimes();
        productOfprimes.productOfprimes(2147483647);
    }
}
