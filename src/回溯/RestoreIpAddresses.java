package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RestoreIpAddresses {
    LinkedList<String> addStr = new LinkedList<>();
    List<String> results = new ArrayList<>();
    int sum = 0;

    public List<String> restoreIpAddresses(String s) {
        String[] strings = s.split("");
        dfs(strings, 0, s.length());
        return results;
    }

    public void dfs(String[] strings, int start, int length) {
        if (addStr.size() == 4) {
            if(length!=sum){
                return;
            }
            results.add(addStr.stream().collect(Collectors.joining(".")));
            return;
        }
        String current = "";
        for (int i = start; i < strings.length; i++) {
            current = current + strings[i];
            if(current.length()>3){
                continue;
            }
            if (current.length() > 1) {
                String first = current.substring(0, 1);
                if (!"0".equals(first) && Long.valueOf(current) <= 255) {
                } else {
                    continue;
                }
            }
            addStr.add(current);
            sum += current.length();
            dfs(strings, i + 1, length);
            addStr.removeLast();
            sum -= current.length();
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses("101023");
    }
}
