package huaweiOd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//最多购买珠宝数目 good
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
        if(list!=null&&list.size()>0){
            System.out.println(list.get(list.size() - 1));
        }else{
            System.out.println("0");
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for(int i =0;i<num;i++){
            int price = sc.nextInt();
            nums[i]=price;
        }
        int allMoneny = sc.nextInt();
        BuyMaxStones main=new BuyMaxStones();
        main.buyMaxStones(allMoneny,nums);
    }
}
