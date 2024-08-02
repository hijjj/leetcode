package huaweiOd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//小朋友来自那个小区 good
public class LittleChildsFromDIfferentPlaces {
    public void littleChildsFromDIfferentPlaces(Map<Integer, Integer> maps) {
        int sum = 0;
        for (Integer i : maps.keySet()) {
            Integer key = i;
            Integer value = maps.get(key);
            if (key >= value) {
                sum = sum + key;
            } else {
                int k = value % key;
                if (k != 0) {
                    sum = sum + (value / key + 1) * key;
                } else {
                    sum = sum + (value / key) * key;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] lines = line.split(" ");
        Map<Integer, Integer> maps = new HashMap<>();
        for (String str : lines) {
            Integer key = Integer.valueOf(str) + 1;
            Integer value = maps.get(key);
            if (value != null) {
                maps.put(key, ++value);
            } else {
                maps.put(key, 1);
            }
        }
        LittleChildsFromDIfferentPlaces l = new LittleChildsFromDIfferentPlaces();
        l.littleChildsFromDIfferentPlaces(maps);
    }
}
