package huaweiOd;

import java.util.*;
//查找众数及中位数 good
public class FindingTheModeAndMedian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lists = new ArrayList<>();
        String[] lines = scanner.nextLine().split(" ");
        FindingTheModeAndMedian findingTheModeAndMedian = new FindingTheModeAndMedian();
        for(int i =0;i<lines.length;i++){
            lists.add(Integer.valueOf(lines[i]));
        }
        findingTheModeAndMedian.findingTheModeAndMedian(lists);

    }
    public void findingTheModeAndMedian(List<Integer> lists) {
        List<Integer> lists2 = new ArrayList<>();
        Map<Integer, Integer> maps = new HashMap<>();
        for (Integer i : lists) {
            Integer value = maps.get(i);
            if (value != null) {
                maps.put(i, value + 1);
            } else {
                maps.put(i, 0);
            }
        }
        int max = maps.values().stream().max((a, b) -> a - b).orElse(0);


        for (Integer key : maps.keySet()) {
            if (max == maps.get(key)) {
                lists2.add(key);
            }
        }

        Collections.sort(lists2);

        int mid = lists2.size()/2;
        if(lists2.size()%2!=0){
            System.out.println(lists2.get(mid));
            return;
        }else {
            int num1 = lists2.get(mid);
            int num2 = lists2.get(mid-1);
            System.out.println((num1+num2)/2);
            return;
        }
    }
}
