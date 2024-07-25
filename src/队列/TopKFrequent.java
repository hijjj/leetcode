package 队列;

import java.util.*;

public class TopKFrequent {
    Map<Integer, Integer> maps = new HashMap<>();

    public int[] topKFrequent(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0) + 1);
        }
        Comparator<Map<Integer, Integer>> comparator = new Comparator<Map<Integer, Integer>>() {
            @Override
            public int compare(Map<Integer, Integer> o1, Map<Integer, Integer> o2) {
                Set<Integer> set2 = o2.keySet();
                Set<Integer> set1 = o1.keySet();
                Integer num1 = 0;
                Integer num2 = 0;
                for (Integer i1 : set1) {
                    num1 = o1.get(i1);
                }
                for (Integer i2 : set2) {
                    num2 = o2.get(i2);
                }
                return num2- num1;
            }
        };
        PriorityQueue<Map<Integer, Integer>> priorityQueue = new PriorityQueue<>(comparator);

        for (Integer key : maps.keySet()) {
            Integer value = maps.get(key);
            Map<Integer, Integer> maps2 = new HashMap<>();
            maps2.put(key, value);
            priorityQueue.add(maps2);
        }
        int[] nums2 = new int[k];
        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> resultMaps = priorityQueue.poll();
            Set<Integer> set = resultMaps.keySet();
            for (Integer j : set) {
                nums2[i] = j;
                break;
            }
        }
        return nums2;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        topKFrequent.topKFrequent(nums,2);
    }
}
