package huaweiOd;

import java.util.*;
//连续字母长度 good
public class LianXuStrLength {
    public static void lianXuStrLength(String s, int k) {
        if(k<=0){
            System.out.println(-1);
            return;
        }
        char first = s.charAt(0);
        int len = 1;
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first == c) {
                len++;
                if (i != s.length() - 1) {
                    continue;
                }

            }
            maps.put(first, len);
            first = c;
            len = 1;

        }
        List<String> lists = new ArrayList<>();
        for (Character c : maps.keySet()) {
            lists.add(String.valueOf(c) + "-" + maps.get(c));
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer num1 = Integer.valueOf(o1.split("-")[1]);
                Integer num2 = Integer.valueOf(o2.split("-")[1]);

                return num2.compareTo(num1);
            }
        };
        Collections.sort(lists, comparator);

        if (k > lists.size()) {
            System.out.println("-1");
            return;
        }
        System.out.println(lists.get(k - 1).split("-")[1]);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int num = scanner.nextInt();
        lianXuStrLength(line, num);
    }
}
