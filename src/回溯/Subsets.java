package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    List<List<Integer>> numLists = new ArrayList<>();
    LinkedList<Integer> addNums = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        for (int j = 0; j <= length; j++) {
            dfs(0, nums, j);
        }
        return numLists;
    }

    public void dfs(int start, int[] nums, int length) {
        if (addNums.size() == length) {
            numLists.add(new ArrayList<>(addNums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            addNums.add(nums[i]);
            dfs(i + 1, nums, length);
            addNums.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        subsets.subsets(nums);
    }
}
