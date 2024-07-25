package 回溯;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum2 {

    LinkedList<Integer> addNums = new LinkedList<>();

    List<List<Integer>> numberLists = new LinkedList<>();
    int sum = 0;
    boolean[] useds;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        useds = new boolean[candidates.length];
        Arrays.fill(useds, false);
        combinationSum3(candidates, target, 0);
        return numberLists;
    }


    public void combinationSum3(int[] candidates, int target, int start) {
        if (sum == target) {
            numberLists.add(new ArrayList<>(addNums));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int currentNumber = candidates[i];
            int current = target - sum;
            if (current < currentNumber || (i > 0 && candidates[i] == candidates[i - 1] && !useds[i - 1])) {
                continue;
            }
            addNums.add(currentNumber);
            useds[i] = true;
            sum += currentNumber;
            combinationSum3(candidates, target, i + 1);
            sum -= currentNumber;
            useds[i] = false;
            addNums.removeLast();

        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2.combinationSum2(nums, 8);
    }
}
