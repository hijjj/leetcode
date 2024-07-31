package huaweiOd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//智能成绩单
public class NumberSplits {
    public void numberSplits(int num) {
        int first = 0;
        for (int i = 2; i <= num; i++) {
            int num2 = num - ((i - 1) * i / 2);
            if(num2<0){
                break;
            }
            if (num2 % i == 0) {
                first = num2 / i;
                break;
            }
        }
        int sum = 0;
        String str = "";
        if (first == 0) {
            System.out.println("N");
            return;
        } else {
            for (int i = first; ; i++) {
                sum = sum + i;
                str = str + i + "+";
                if (sum == num) {
                   break;
                }
            }
        }
        System.out.println(num + "=" + str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        NumberSplits numberSplits = new NumberSplits();
        numberSplits.numberSplits(107374182);
    }
}
