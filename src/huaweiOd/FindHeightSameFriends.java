package huaweiOd;

import java.util.*;
//小朋友的身高
public class FindHeightSameFriends {
    public void findHeightSameFriends(int height, int nums, int[] friendsHeight) {
        Comparator<Map<Integer, Integer>> comparator = new Comparator<Map<Integer, Integer>>() {
            @Override
            public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
                Integer value01 = null;
                Integer height01 = null;
                Integer value02 = null;
                Integer height02 = null;

                for (Integer i1 : o1.values()) {
                    value01 = height - i1 > 0 ? height - i1 : -(height - i1);
                    height01 = i1;
                    break;
                }
                for (Integer i2 : o2.values()) {
                    value02 = height - i2 > 0 ? height - i2 : -(height - i2);
                    height02 = i2;
                    break;
                }
                if (value01.compareTo(value02) == 0) {
                    return height01 - height02;
                } else {
                    return value01 - value02;
                }
            }
        };
        PriorityQueue<Map<Integer, Integer>> priorityQueue = new PriorityQueue(comparator);

        //身高差
        for (int i = 0; i < friendsHeight.length; i++) {
            Map<Integer, Integer> heightMaps = new TreeMap();
            heightMaps.put(i, friendsHeight[i]);
            priorityQueue.add(heightMaps);
        }
        while (!priorityQueue.isEmpty()) {
            Map<Integer, Integer> maps = priorityQueue.poll();
            for (Integer i : maps.values()) {
                System.out.print(i + " ");
                break;
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer height = scanner.nextInt();
        Integer num = scanner.nextInt();
        Scanner scanner2 = new Scanner(System.in);

        String heightTts = scanner2.nextLine();
        int[] nums = new int[num];
        String[] heights = heightTts.split(" ");
        for (int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(heights[i]);
        }
        FindHeightSameFriends findHeightSameFriends = new FindHeightSameFriends();
        findHeightSameFriends.findHeightSameFriends(height, num, nums);
    }
}
