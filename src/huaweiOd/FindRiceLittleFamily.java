package huaweiOd;

import java.util.*;
//找到最富有的家庭 good
public class FindRiceLittleFamily {
    public void findRiceLittleFamily(Map<Integer, List<Integer>> familys, int[] moneys) {
        List<Integer> allMoney= new ArrayList<>();
        int sum = 0;
        for (Integer i : familys.keySet()) {
            List<Integer> lists = familys.get(i);
            // 移除list其中的parent
            sum = sum + moneys[i - 1];
            for (Integer j : lists) {
                sum = sum + moneys[j - 1];
            }
            allMoney.add(sum);
            sum=0;
        }
        Collections.sort(allMoney);
        System.out.println(allMoney.get(allMoney.size()-1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String line = scanner.nextLine();
        if("1".equals(nums)){
            System.out.println(line);
            return;
        }
        String[] lines = line.split(" ");
        int[] moneys = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            moneys[i] = Integer.parseInt(lines[i]);
        }
        Map<Integer, List<Integer>> maps = new HashMap<>();
        boolean result = true;
        int nums1 = 1;
        while (result) {
            String line1 = scanner.nextLine();
            String[] line1s = line1.split(" ");
            List<Integer> lists = new ArrayList<>();
            for (int i = 1; i < line1s.length; i++) {
                lists.add(Integer.valueOf(line1s[i]));
            }
            List<Integer> lists2 = maps.get(Integer.valueOf(line1s[0]));
            if (lists2 != null && !lists2.isEmpty()) {
                lists2.addAll(new ArrayList<>(lists));
            } else {
                maps.put(Integer.valueOf(line1s[0]), lists);
            }
            if (nums1 == lines.length - 1) {
                result = false;
            }
            nums1++;
        }
        FindRiceLittleFamily findRiceLittleFamily = new FindRiceLittleFamily();
        findRiceLittleFamily.findRiceLittleFamily(maps, moneys);

    }
}
