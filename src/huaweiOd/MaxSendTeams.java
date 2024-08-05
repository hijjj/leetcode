package huaweiOd;

import java.util.*;

//最多派遣多少个队伍 good
public class MaxSendTeams {
    public void maxSendTeams(int min, List<Integer> abilitys) {
        int sum = 0;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Collections.sort(abilitys, comparator);;

         int left =0;
         int right = abilitys.size()-1;
         //单人
         for(int i=right;i>=left;i--){
             if(abilitys.get(i)>=min) {
                 right--;
                 sum++;
             }
         }
         while(left<right){
             int all = abilitys.get(left)+abilitys.get(right);
             if(all>=min){
                 sum++;
                 left++;
                 right--;
             }else {
                 left++;
             }
         }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        MaxSendTeams maxSendTeams = new MaxSendTeams();
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();
        List<Integer> lists =new ArrayList<>();
        for(int i =0;i<nums;i++){
            lists.add( scanner.nextInt());
        }
        maxSendTeams.maxSendTeams(scanner.nextInt(), lists);
    }
}
