package huaweiOd;

import java.util.*;
//cpu good
public class Cpu2 {
    public  static void cup2(List<Integer> lists1,List<Integer> lists2){
        int sum1 = lists1.stream().mapToInt(u->u).sum();
        int sum2 = lists2.stream().mapToInt(u->u).sum();
        List<String> lists = new ArrayList<>();
        for(Integer i:lists1){
            int change1 = i;
            int change2 = change1-(sum1-sum2)/2;
            if(lists2.contains(change2)){
               lists.add(change1+"-"+change2);
            }
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {


                return Integer.valueOf(o1.split("-")[0])-Integer.valueOf(o2.split("-")[0]);
            }
        };
        Collections.sort(lists,comparator);
        System.out.println(lists.get(0).split("-")[0]+" "+lists.get(0).split("-")[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        List<Integer> lists = new ArrayList<>();
        for(int i=0;i<num1;i++){
            lists.add(scanner.nextInt());
        }
        List<Integer> lists2 = new ArrayList<>();
        for(int i=0;i<num2;i++){
            lists2.add(scanner.nextInt());
        }
        cup2(lists,lists2);
    }
}
