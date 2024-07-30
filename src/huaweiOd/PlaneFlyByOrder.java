package huaweiOd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//飞机场飞机按序飞行
public class PlaneFlyByOrder {
    public void planeFlyByOrder(List<String> lists) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //前两位
                String str1 = o1.substring(0, 2);
                String str2 = o2.substring(0, 2);
                //后4位
                Integer num1 = Integer.valueOf(o1.substring(2));
                Integer num2 = Integer.valueOf(o2.substring(2));
                char[] c1 = str1.toCharArray();
                char[] c2 = str2.toCharArray();
                for (int i = 0; i < c1.length; i++) {
                    if (c1[i] != c2[i]) {
                        return c1[i] - c2[i];
                    }
                }
                return num1.compareTo(num2);

            }
        };
        Collections.sort(lists, comparator);
        String str1 = "";
        for (String str : lists) {
            str1 = str1 + str + ",";
        }
        System.out.println(str1.substring(0,str1.length()-1));
    }

    public static void main(String[] args) {
        PlaneFlyByOrder planeFlyByOrder =new PlaneFlyByOrder();
        String[] strings = {"MU1087","CA9908","3U0045","FM1703"};

        planeFlyByOrder.planeFlyByOrder(Arrays.asList(strings));
    }
}
