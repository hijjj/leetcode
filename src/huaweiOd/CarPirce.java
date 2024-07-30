package huaweiOd;

import java.util.Scanner;
//靠谱的坐车价格
public class CarPirce {
    public void carPrice(int num) {
        int count = 0;
        int i =0;
        while (count != num) {
            i++;
            count++;
            count = Integer.valueOf(String.valueOf(count).replace("4", "5"));
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        CarPirce carPirce = new CarPirce();
        carPirce.carPrice(num);
    }
}
