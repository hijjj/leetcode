package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//考情信息 good
public class NoAbsentTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num =Integer.valueOf(scanner.nextLine());
        List<String> lists = new ArrayList<>();
        for(int i =0;i<num;i++){
            lists.add(scanner.nextLine());
        }
        NoAbsentTime noAbsentTime = new NoAbsentTime();


        noAbsentTime.noAbsentTime(num,lists);
    }
    public void noAbsentTime(int num, List<String> lists) {
        for (String s : lists) {
            boolean flag1 = checkAbsentOneTime(s);
            boolean flag2 = checkNoLateAndLeaveearly(s);
            boolean flag3 = sevenTimesNotThreeTime(s);

            System.out.print((flag1 && flag2 && flag3) + " ");
        }
    }

    public boolean checkAbsentOneTime(String time) {
        String[] strings = time.split(" ");
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if ("absent".equals(strings[i])) {
                count++;
            }
        }
        if (count > 1) {
            return false;
        }

        return true;
    }

    public boolean checkNoLateAndLeaveearly(String time) {
        String str1 = "late leaveearly";
        String str3 = "late late";
        String str4 = "leaveearly leaveearly";

        String str2 = "leaveearly late";
        return !(time.contains(str1) || time.contains(str2)|| time.contains(str3)|| time.contains(str4));
    }

    public boolean sevenTimesNotThreeTime(String time) {
        String[] times = time.split(" ");
        int left = 0;
        int right = 6;
        int count = 0;
        String str="";
        if (times.length < 7) {
            count = getCount(times, count);
        } else {
            while (right < time.length()) {
                for(int i =left;i<=right;i++){
                    str =str+times[i]+" ";
                }
                count = getCount(str.split(" "), count);
                if (count > 3) {
                    return false;
                }
                left = left + 1;
                if (left > times.length - 1) {
                    break;
                }
                right = right + 1;
                if (right > times.length - 1) {
                    right = times.length - 1;
                }
                str="";
                count=0;
            }
        }
        if (count > 3) {
            return false;
        }

        return true;
    }

    private static int getCount(String[] times, int count) {
        for (String string : times) {
            if (string.equals("absent") || string.equals("late") || string.equals("leaveearly")) {
                count++;
            }
        }
        return count;
    }
}

