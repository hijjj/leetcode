package huaweiOd;

import java.util.*;

//分配土地 good
public class LandAllocation {
    public void landAllocation(Map<Integer, List<String>> maps) {
        List<Integer> lists1 = new ArrayList<>();
        for (Integer key : maps.keySet()) {
            List<String> lists = maps.get(key);
            if (lists.size() == 1) {
                continue;
            }
            int maxX = 0;
            int minX = 0;
            int maxY = 0;
            int minY = 0;
            List<Integer> xLists = new ArrayList<>();
            List<Integer> yLists = new ArrayList<>();
            for (String str : lists) {
                Integer x = Integer.valueOf(str.split("-")[0]);
                Integer y = Integer.valueOf(str.split("-")[1]);
                xLists.add(x);
                yLists.add(y);
            }
            Collections.sort(xLists);
            Collections.sort(yLists);

            maxX = xLists.get(xLists.size() - 1);
            minX = xLists.get(0);
            maxY = yLists.get(yLists.size() - 1);
            minY = yLists.get(0);
            lists1.add((maxX - minX + 1) * (maxY - minY + 1));
        }
        Collections.sort(lists1);
        System.out.println(lists1.get(lists1.size() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line0 = scanner.nextLine();
        Integer  nums = Integer.valueOf(line0.split(" ")[0]);
        List<String> lists = new ArrayList<>();
        int h=1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            lists.add(line);
            if(nums==h){
                break;
            }
            h++;
        }
        Map<Integer, List<String>> maps = new HashMap<>();
        int x = 0;
        for (String str : lists) {
            String[] strings = str.split(" ");
            for (int i = 0; i < strings.length; i++) {
                Integer key = Integer.valueOf(strings[i]);
                if(key==0){
                    continue;
                }
                List<String> lists3 = maps.get(key);
                if (lists3==null) {
                    List<String> list = new ArrayList<>();
                    list.add(x + "-" + i);
                    maps.put(key, list);
                } else {
                    List<String> list = maps.get(key);
                    list.add(x + "-" + i);
                }
            }
            x++;
        }
        LandAllocation l = new LandAllocation();
        l.landAllocation(maps);
    }
}
