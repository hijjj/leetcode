package huaweiOd;

import java.util.*;
//api集群
public class ApiSum {
    public void apiSum(int floor, Map<String, List<String>> map, String string) {
        int sum = 0;
        for (String key : map.keySet()) {
            List<String> lists = map.get(key);
            int size = lists.size();
            if (floor > size || !lists.get(floor - 1).equals(string)) {
                continue;
            }
            sum++;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> lists = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Scanner scanner1 = new Scanner(System.in);
            String str = scanner1.nextLine();
            lists.add(str);
        }
        Scanner scanner1 = new Scanner(System.in);
        int floor = scanner1.nextInt();
        String str = scanner1.next();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            String str1 = lists.get(i);
            String[] messages = str1.split("/");
            List<String> messageLists = new ArrayList<>();
            for (int j = 1; j < messages.length; j++) {
                messageLists.add(messages[j]);
            }
            map.put(String.valueOf(i), messageLists);
        }

        ApiSum apiSum = new ApiSum();
        apiSum.apiSum(floor, map, str);
    }
}
