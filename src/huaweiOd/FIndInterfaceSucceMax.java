package huaweiOd;

import java.util.*;
//计算接口成功率
public class FIndInterfaceSucceMax {
    public void findInterfaceSucceMax(int minAverageLost, int[] nums) {
        int sum = 0;
        List<List<String>> lists1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<String> lists = new ArrayList<>();
            sum = nums[i];
            if (nums[i] <= minAverageLost) {
                lists.add(i+"");
                List<String> lists12 = new ArrayList<>();
                lists12.addAll(lists);
                lists1.add(lists12);
            }else {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                double avarage = ((double) sum / (j - i + 1));
                if (avarage <= minAverageLost) {
                    lists.add(j + "");
                } else {
                    break;
                }
            }
            lists1.add(lists);
        }
        Comparator<List<String>> comparator = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int size = o1.size();
                int size2 = o2.size();
                return size - size2;
            }
        };
        Collections.sort(lists1, comparator);

        List<String> lists2 = lists1.get(lists1.size() - 1);

        for (int i = 0; i < lists1.size(); i++) {
            if (lists2.size() == lists1.get(i).size()) {
                List<String> lists3 = lists1.get(i);
                System.out.print(lists3.get(0) + "-" + lists3.get(lists3.size() - 1)+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        FIndInterfaceSucceMax fIndInterfaceSucceMax = new FIndInterfaceSucceMax();
        fIndInterfaceSucceMax.findInterfaceSucceMax(num, nums);
    }
}
