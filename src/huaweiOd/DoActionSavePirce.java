package huaweiOd;

import java.util.*;

//执行任务赚积分
public class DoActionSavePirce {
    public void doActionSavePirce(int time, Map<Integer, List<Integer>> maps1) {
        int res=0;
        //将任务根据时间和积分大小排序，将同一时间积分小的过滤掉
        Map<Integer, Integer> maps = new HashMap<>();
        for (Integer i : maps1.keySet()) {
            List<Integer> lists = maps1.get(i);
            Collections.sort(lists);
            maps.put(i, lists.get(lists.size() - 1));
        }
        for (int i = 1; i <= time; i++) {
              Integer score= maps.get(i);
              if(score!=null){
                  res=res+score;
              }
        }

        System.out.println(res);
    }

    public static void main(String[] args) {
        DoActionSavePirce doActionSavePirce1 = new DoActionSavePirce();
        Map<Integer,List<Integer>> maps=new HashMap<>();
        List<Integer> lists  = new ArrayList<>();
        lists.add(2);
        lists.add(3);   lists.add(4);   maps.put(1,lists);
        Map<Integer,List<Integer>> maps2=new HashMap<>();
        List<Integer> lists2  = new ArrayList<>();
        lists2.add(5);
        maps.put(3,lists2);
        doActionSavePirce1.doActionSavePirce(3,maps);
    }
}
