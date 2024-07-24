package 回溯;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class CombinationSum {
    LinkedList<Integer> addNums = new LinkedList<>();
    List<List<Integer>> combinationLists = new ArrayList<>();


    List<String> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        combinationSum2(candidates, target);
        List<String> reults2 = results.stream().distinct().collect(Collectors.toList());

        for (String str : reults2) {
            String[] i = str.split(",");
            List<Integer> lists = new ArrayList<>();

            for(String string:i){
                lists.add(Integer.valueOf(string));
            }
            combinationLists.add(lists);
        }
        return combinationLists;
    }

    public void combinationSum2(int[] candidates, int target) {
        int sum = addNums.stream().mapToInt(u -> u).sum();
        if (target == sum) {
            LinkedList<Integer> newLists = new LinkedList<>();
            newLists.addAll(addNums);
            Collections.sort(newLists);
            String result = newLists.stream().map(String::valueOf).collect(Collectors.joining(","));
            results.add(result);
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            addNums.add(candidates[i]);
            combinationSum2(candidates, target);
            addNums.removeLast();
        }

    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] nums = {7,3,2};
        combinationSum.combinationSum(nums, 18);
    }
}
