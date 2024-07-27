package 贪心算法;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        List<Integer> fuLists = new ArrayList<>();
        List<Integer> allLists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                fuLists.add(nums[i]);
                continue;
            }
            allLists.add(nums[i]);
        }
        Collections.sort(fuLists);
        Collections.sort(allLists);

        if (!allLists.isEmpty()) {
            int minZhi = allLists.get(0);
            if (!fuLists.isEmpty()) {
                int flag = 0;
                int maxFu = fuLists.get(fuLists.size() - 1);
                int h = 0;
                int index = 0;
                int flag2 = 0;
                int maxFu2 = 0;
                for (int j = 0; j < k; j++) {
                    if (h < fuLists.size()) {
                        Integer fu = -fuLists.get(0);
                        fuLists.remove(0);
                        fuLists.add(fu);
                        h++;
                        continue;
                    } else {
                        flag = 1;
                        maxFu = maxFu > 0 ? maxFu : -maxFu;
                        if (maxFu >= minZhi) {
                            if (flag2 != 1) {
                                for (int x = 0; x < allLists.size(); x++) {
                                    if (allLists.get(x) == minZhi) {
                                        flag2 = 1;
                                        index = x;
                                        break;
                                    }
                                }
                            }
                            minZhi = -minZhi;
//                        allLists.remove(index);
//                        allLists.add(-minZhi);
                        } else {
                            if (flag2 != 1) {
                                for (int x = 0; x < fuLists.size(); x++) {
                                    if (fuLists.get(x) == maxFu) {
                                        maxFu2 = maxFu;
                                        flag2 = 1;
                                        index = x;
                                        break;
                                    }
                                }
                            }
                            maxFu2 = -maxFu2;
//                        fuLists.remove(index);
//                        fuLists.add(-maxFu);
                        }
                    }
                }
                if (flag == 1 && maxFu >= minZhi) {
                    allLists.remove(index);
                    allLists.add(minZhi);
                    allLists.addAll(fuLists);
                } else if (flag == 1 && maxFu < minZhi) {
                    fuLists.remove(index);
                    fuLists.add(maxFu2);
                    allLists.addAll(fuLists);
                } else {
                    allLists.addAll(fuLists);
                }
            } else {
                int index = 0;
                for (int j = 0; j < k; j++) {
                    for (int x = 0; x < allLists.size(); x++) {
                        if (allLists.get(x) == minZhi) {
                            index = x;
                            break;
                        }
                    }
                    minZhi = -minZhi;
                }
                allLists.remove(index);
                allLists.add(minZhi);
            }
        } else {
            int h = 0;
            int min=0;
            int flag = 0;
            for (int j = 0; j < k; j++) {

                if (h < fuLists.size()) {
                    Integer fu = -fuLists.get(0);
                    fuLists.remove(0);
                    fuLists.add(fu);
                    h++;
                    continue;
                }
                Collections.sort(fuLists);
                if(flag!=1){
                    min=fuLists.get(0);
                    min=-min;
                }else {
                    min=-min;
                }
                flag=1;

            }
            fuLists.remove(0);
            fuLists.add(min);
            allLists.addAll(fuLists);
        }
        return allLists.stream().mapToInt(u -> u).sum();
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations = new LargestSumAfterKNegations();
        int[] nums = {-4, -2, -3};
        largestSumAfterKNegations.largestSumAfterKNegations(nums, 4);
    }
}
