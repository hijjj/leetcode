package huaweiOd;

import java.util.*;

//最长指定瑕疵度元音字符串 good
public class MaxStrYuans {
    static Character[] nums = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

    public static void maxStrYuans(int num, String s) {
        int max = 0;
        List<Character> lists = Arrays.asList(nums);
        List<Integer> yuanLists = new ArrayList<>();
        String[] strings = s.split("");
        for (int i = 0; i < s.length(); i++) {
            if (lists.contains(strings[i].toCharArray()[0])) {
                yuanLists.add(i);
            }
        }
        int right =0;
        int left = 0;

        while (right <yuanLists.size()) {
            int rightValue = yuanLists.get(right);
            int leftValue = yuanLists.get(left);
            int i = rightValue-leftValue-(right-left);
            if (num == i) {
                max =Math.max(max,rightValue-leftValue+1);
                right++;
            } else if (num>i) {
                right++;
            }else {
                left++;
            }
        }
      System.out.println(max);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String line = scanner.next();
        maxStrYuans(num, line);
    }
}
