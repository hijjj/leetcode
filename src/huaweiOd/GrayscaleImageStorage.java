package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 灰度图存储 good
public class GrayscaleImageStorage {

    public static void grayscaleImageStorage(int h, int l, List<String> lists, int targeth, int targetl) {
        int[] nums = new int[h * l];
        int start = 0;
        for (int i = 0; i < lists.size(); i++) {
            int gray = Integer.valueOf(lists.get(i).split(  "-")[0]);
            int length = Integer.valueOf(lists.get(i).split("-")[1]);
            Arrays.fill(nums, start, start + length, gray);
            start += length;
        }

        int index = l * (targeth) + targetl;

        System.out.println(nums[index]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lines = scanner.nextLine();
        String[] strings = lines.split(" ");
        int h = Integer.valueOf(strings[0]);
        int l = Integer.valueOf(strings[1]);
        List<String> lists = new ArrayList<>();
        for (int i = 2; i < strings.length; ) {
            String str = strings[i]+"-"+strings[i + 1];
            lists.add(str);
            i = i + 2;
        }

        String[] strings1 = scanner.nextLine().split(" ");

        int num1 = Integer.valueOf(strings1[0]);
        int num2 = Integer.valueOf(strings1[1]);
         grayscaleImageStorage(h,l,lists,num1,num2);
    }
}
