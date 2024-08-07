package huaweiOd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//多段线数据压缩 good
public class PolylineDataCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split(" ");
        List<List<Integer>> lists = new ArrayList<>();
        int n = lines.length / 2;
        int i = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> list1 = new ArrayList<>();
            list1.add(Integer.valueOf(lines[i]));
            list1.add(Integer.valueOf(lines[i + 1]));
            lists.add(list1);
            i = i + 2;
        }

        polylineDataCompression(lists);
    }

    public static void polylineDataCompression(List<List<Integer>> lists) {
        List<List<Integer>> lists1 = new ArrayList<>();
        int preOffsetX = 0;
        int preOffsetY = 0;
        int preX=lists.get(0).get(0);
        int preY=lists.get(0).get(1);
        for (int i = 1; i < lists.size(); i++) {
            List<Integer> first = lists.get(i);
            int x1 = first.get(0);
            int y1 = first.get(1);
            int x2 = preX;
            int y2 = preY;
            int offsetX = x1 - x2;
            int offsetY = y1 - y2;
            int base = Math.max(Math.abs(offsetX), Math.abs(offsetY));
            int currentX = offsetX / base;
            int currentY = offsetY / base;
            if (currentX != preOffsetX || currentY != preOffsetY) {
                List<Integer> lists2 = new ArrayList<>();
                lists2.add(preX);
                lists2.add(preY);
                lists1.add(lists2);
            }
            preOffsetX = offsetX / base;
            preOffsetY = offsetY / base;

            preX = x1;
            preY=y1;
        }

        List<Integer> lists4 = new ArrayList<>();
        lists4.add(preX);
        lists4.add(preY);
        lists1.add(lists4);
        for (List<Integer> lists3 : lists1) {
            List<Integer> list4 = lists3;
            System.out.print(list4.get(0) + " ");
            System.out.print(list4.get(1) + " ");
        }

    }
}
