package huaweiOd;

import java.util.*;
//围棋的气 good
public class WeiQiliberty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);

        String input2 = scanner2.nextLine();
        String[] str1 = input1.split(" ");
        String[] str2 = input2.split(" ");
        String[] whites = new String[str1.length / 2];
        String[] blacks = new String[str2.length / 2];
        int k = 0;
        for (int i = 0; i < str1.length ;) {

            whites[k] = Integer.parseInt(str1[i]) + "-" + Integer.parseInt(str1[i + 1]);
            i=i+2;
            k++;
        }
        int j = 0;
        for (int i = 0; i < str2.length;) {

            blacks[j] = Integer.parseInt(str2[i]) + "-" + Integer.parseInt(str2[i + 1]);
            i=i+2;
            j++;
        }
        WeiQiliberty weiQiliberty = new WeiQiliberty();
        // 黑色的数量
       int w= weiQiliberty.build(whites, blacks);
        // 白色的数量
        int b = weiQiliberty.build(blacks, whites);
        System.out.println(b+" "+w);
    }

    public Integer build(String[] w, String[] b) {
        Set<String> set = new HashSet<>();
        for (String str : w) {
            set.add(str);
            Integer num0 = Integer.valueOf(str.split("-")[0]);
            Integer num1 = Integer.valueOf(str.split("-")[1]);
            if (num0 > 0 && num0 < 18 && num1 > 0 && num1 < 18) {
                //上
                set.add(String.valueOf(num0 - 1) + "-" + String.valueOf(num1));
                //下
                set.add(String.valueOf(num0 + 1) + "-" + String.valueOf(num1));
                //左
                set.add(num0 + "-" + (num1 - 1));
                //右
                set.add(num0 + "-" + (num1 + 1));
            }
            if (num0 == 0 && num1 < 18 && num1 != 0) {
                //下
                set.add(String.valueOf(num0 + 1) + "-" + String.valueOf(num1));
                //左
                set.add(num0 + "-" + (num1 - 1));
                //右
                set.add(num0 + "-" + (num1 + 1));
            }
            if (num1 == 0 && num0 < 18 && num0 != 0) {
                //上
                set.add(String.valueOf(num0 - 1) + "-" + String.valueOf(num1));
                //下
                set.add(String.valueOf(num0 + 1) + "-" + String.valueOf(num1));
                //右
                set.add(num0 + "-" + (num1 + 1));
            }
            if (num0 == 18 && num1 < 18 && num1 != 0) {
                //上
                set.add(String.valueOf(num0 - 1) + "-" + String.valueOf(num1));
                //左
                set.add(num0 + "-" + (num1 - 1));
                //右
                set.add(num0 + "-" + (num1 + 1));
            }
            if (num1 == 18 && num0 < 18 && num0 != 0) {
                //上
                set.add(String.valueOf(num0 - 1) + "-" + String.valueOf(num1));
                //下
                set.add(String.valueOf(num0 + 1) + "-" + String.valueOf(num1));
                //左
                set.add(num0 + "-" + (num1 - 1));
            }
            if (num0 == 0 && num1 == 0) {
                //下
                set.add(String.valueOf(num0 + 1) + "-" + String.valueOf(num1));
                //右
                set.add(num0 + "-" + (num1 + 1));
            }

            if (num0 == 0 && num1 == 18) {
                //下
                set.add(String.valueOf(num0 + 1) + "-" + String.valueOf(num1));
                //左
                set.add(num0 + "-" + (num1 - 1));
            }
            if (num0 == 18 && num1 == 0) {
                //右
                set.add(num0 + "-" + (num1 + 1));
                //上
                set.add(String.valueOf(num0 - 1) + "-" + String.valueOf(num1));
            }
            if (num0 == 18 && num1 == 18) {
                //上
                set.add(String.valueOf(num0 - 1) + "-" + String.valueOf(num1));
                //左
                set.add(num0 + "-" + (num1 - 1));
            }
        }
        int whiteLibertyCount= set.size()- w.length;

        //黑色气

        for(String string:b){
            if(set.contains(string)){
                whiteLibertyCount--;
            }
        }
        return whiteLibertyCount;
    }
}
