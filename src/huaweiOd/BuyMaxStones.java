package huaweiOd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//最多购买珠宝数目
public class BuyMaxStones {
    public void buyMaxStones(int allMoneny, int[] monenys) {
        int res = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < monenys.length; i++) {
            res = res + monenys[i];
            if (res > allMoneny) {
                res=0;
                continue;
            }
            count++;
            list.add(count);
            for (int j = i + 1; j < monenys.length; j++) {
                res = res + monenys[j];
                if (res > allMoneny) {
                    break;
                }
                count++;
            }
            list.add(count);
            res=0;
            count=0;
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    public static void main(String[] args) {
        BuyMaxStones buyMaxStones = new BuyMaxStones();
        int[] nums = {8,4,6,3,1,6,7};
        buyMaxStones.buyMaxStones(10, nums);
    }
}
