package huaweiOd;


import java.util.*;
import java.util.stream.Collectors;

//数组去重 good
public class SuzuDistinct {


    public static void calucate(List<Integer> lists) {
       List<Integer> distinct = lists.stream().distinct().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < lists.size(); i++) {
            Integer key = lists.get(i);
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }
        List<String> lists2 = new ArrayList<>();
        int i = 0;
        for (Integer key : map.keySet()) {
            lists2.add(key + ":" + map.get(key));
            i++;
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int num1 = Integer.valueOf(o1.split(":")[1]);
                int num2 = Integer.valueOf(o2.split(":")[1]);
                if (num1 != num2) {
                    return num2 - num1;
                } else {
                    int key1 = Integer.valueOf(o1.split(":")[0]);
                    int key2 = Integer.valueOf(o2.split(":")[0]);
                    int o=0;
                    int index1=0;
                    int index2=0;
                    for(Integer integer:distinct){
                        if(integer==key1){
                            index1 = o;
                        }
                        if(integer==key2){
                            index2=o;
                        }
                        o++;
                    }
                    return index1-index2;

                }
            }
        };

        Collections.sort(lists2, comparator);
        StringBuffer stringBuffer = new StringBuffer();
        for (String i1 : lists2) {
            stringBuffer.append(i1.split(":")[0]).append(",");
        }

        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(",");
        Integer[] integerArray = Arrays.stream(s)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        calucate(Arrays.asList(integerArray));
    }
}
