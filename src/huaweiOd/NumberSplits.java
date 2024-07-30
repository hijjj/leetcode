package huaweiOd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberSplits {
    public void numberSplits(int num) {
        int sum = 0;
        List<String> lists = new ArrayList<>();
        int n = num / 2;
        if (n == 0) {
            System.out.println(1);
            return;
        } else {
            int a = 1;
            int count = 0;
            for (int i = a; i <= n; i++) {
                int nums = i;
                String numstr = "";
                while (sum < num) {
                    count++;
                    sum = sum + nums;
                    numstr = numstr + nums + "+";
                    nums++;
                    if(nums>n){
                        break;
                    }
                    if (num == sum) {
                        lists.add(numstr.substring(0, numstr.length() - 1));
                    }
                }
                sum = 0;
            }
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] strings1 = o1.split("\\+");
                String[] strings2 = o2.split("\\+");
                return strings1.length - strings2.length;
            }
        };
        Collections.sort(lists, comparator);
        System.out.println(num + "=" + lists.get(0));
    }

    public static void main(String[] args) {
        NumberSplits numberSplits = new NumberSplits();
        numberSplits.numberSplits(1073741824);
    }
}
