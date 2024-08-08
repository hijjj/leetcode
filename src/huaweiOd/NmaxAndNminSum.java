package huaweiOd;

import java.util.*;
//最大N个数与最小N个数的和 good
public class NmaxAndNminSum {
    public static void nmaxAndNminSum(List<Integer> lists, int num) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        set.addAll(lists);
        if (set.size() < 2 * num) {
            System.out.println(-1);
            return;
        }
        int n = set.size();
        int left = 0;
        int right = n - 1;
        List<Integer> lists1 = new ArrayList<>();
        lists1.addAll(set);
        Collections.sort(lists1);
        while (num > 0) {
            sum = sum + lists1.get(left) + lists1.get(right);
            left++;
            right--;
            num--;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer num1 = scanner.nextInt();
            if (num1 < 0 || num1 > 1000) {
                System.out.println(-1);
                return;
            }
            lists.add(num1);
        }
        int k = scanner.nextInt();
        if (lists.size() < k) {
            System.out.println(-1);
            return;
        }
        if (k < 0) {
            System.out.println(-1);
            return;
        }
        nmaxAndNminSum(lists, k);
    }
}
