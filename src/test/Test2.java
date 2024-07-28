package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test2 {
    public void test(int i) {
        i++;
        System.out.println(i);

        test(i);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test(1);
        Map<String, String> maps = new HashMap<>();
        Set<Entry<String, String>> set = maps.entrySet();
        for (Entry entry : set) {

        }
    }
}
