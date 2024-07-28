package ACMModel;

import java.util.Scanner;

public class AcmTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String a = s.next();
            System.out.println("1" + a);
//           String b = s.nextLine();
//           System.out.println("2" + b);

            Integer c = s.nextInt();
            System.out.println("3" + c);

            double d = s.nextDouble();
            System.out.println("4" + d);

        }
    }
}
