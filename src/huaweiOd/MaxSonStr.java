package huaweiOd;

import java.util.*;
// 求满足条件的最长子串的长度 good
public class MaxSonStr {

    public static void maxSonStr(String str) {
        //字符个数
        List<Integer> counts = new ArrayList<>();
        char[] c = str.toCharArray();
        int zimu=0;
        int shuzi=0;
        for(char c1:c){
            if(check(c1)){
                zimu++;
            }else {
                shuzi++;
            }
        }
        if(shuzi==0||zimu==0){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < c.length; i++) {
            int strNums = 0;
            int count = 0;

            for (int k = i + 1; k < c.length; k++) {
                if (check(c[i])) {
                    if (!check2(c[k])) {
                        break;
                    }
                    if (count == 0) {
                        count = 1;
                    }
                    count++;
                } else {

                    if ( check(c[k])) {
                        strNums++;
                    }
                    if (strNums > 1) {
                        break;
                    }
                    if (count == 0) {
                        count = 1;
                    }
                    count++;
                }
            }
            if (count == 0) {
                continue;
            }
            counts.add(count);
        }
        Collections.sort(counts);
        System.out.println(counts.get(counts.size() - 1));
    }

    public static boolean check(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public static boolean check2(char c) {
        if ((c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        maxSonStr(line);
    }
}
