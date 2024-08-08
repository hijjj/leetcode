package huaweiOd;

import java.util.*;
import java.util.stream.Collectors;
//整型数组按个位值排序 good
public class SortingAnIntegerArray {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        List<String> lists= new ArrayList<>();
        String[] lines = scanner.nextLine().split(",");
        for(int i=0;i<lines.length;i++){
            lists.add(lines[i]);
        }
        sortingAnIntegerArray(lists);
    }
    public  static void sortingAnIntegerArray(List<String> lists){
        Comparator<String> comparator =new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer value1 = Integer.valueOf(o1.replace("-","").split("")[o1.replace("-","").length()-1]);
                Integer value2 = Integer.valueOf(o2.replace("-","").split("")[o2.replace("-","").length()-1]);

                return value1.compareTo(value2);}
        };
        Collections.sort(lists,comparator);

        System.out.println(lists.stream().collect(Collectors.joining(",")));
    }
}
