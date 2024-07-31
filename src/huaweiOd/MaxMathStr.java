package huaweiOd;

import java.util.HashMap;
import java.util.Map;

//提取字符串中最长的数学表达式
public class MaxMathStr {
    public void maxMathStr(int[] nums) {
        int res = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] + 1;
            if (maps.get(key) != null) {
                maps.put(key, maps.get(key) + 1);
            } else {
                maps.put(key, 1);

            }
        }

        for (Integer i : maps.keySet()) {
            Integer key = i;
            Integer value = maps.get(key);
            if (key >= value) {
                res = res + key;
            } else {
                int num = value/key;
                if (value % key == 0) {
                     res=res+key*(num);
                }else {
                    res=res+key*(num+1);
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        MaxMathStr maxMathStr = new MaxMathStr();
        int[] nums ={2,2,3};
        maxMathStr.maxMathStr(nums);
    }
}
