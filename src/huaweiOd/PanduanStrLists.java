package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//字符串序列判定 good
public class PanduanStrLists {
    public static void panduanStrLists(String string1, String string2) {
        String[] s1 = string1.split("");
        String[] s2 = string2.split("");
        List<Integer> lists = new ArrayList<>();
        boolean flag = false;
        int tmp = 0;
        boolean start = true;
        for (int i = 0; i < s1.length; i++) {
            int k =start?0: tmp+1;
            for (int j = k; j < s2.length; j++) {
                if (s1[i].equals(s2[j])) {
                    flag = true;
                    lists.add(j);
                    tmp = j;
                    break;
                }
                start =false;
            }
            if (flag == false) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(lists.get(lists.size() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        panduanStrLists(line1, line2);
    }
}
