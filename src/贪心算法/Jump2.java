package 贪心算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jump2 {
    int sum = 0;

    public int jump(int[] nums) {
        if(nums.length==0&& nums[0]==0){
            return 1;
        }
        dfs(nums.length - 1, nums);
        return sum;
    }

    public void dfs(int index, int[] nums) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = index; i >= 0; i--) {
            if (nums[i] >= index - i) {
                indexs.add(i);
            }
        }
        Collections.sort(indexs);
        index = indexs.get(0);
        sum++;
        if (index != 0) {
            dfs(index, nums);
        }
    }
}
