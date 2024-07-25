package 回溯;

import java.util.*;

public class Partition {
    int sum = 0;
    LinkedList<String> addNums = new LinkedList<>();

    List<List<String>> strLists = new ArrayList<>();

    public List<List<String>> partition(String s) {
        String[] string = s.split("");
        dfs(0, string, string.length);
        return strLists;
    }

    public void dfs(int start, String[] strings, int length) {
        if (sum == length) {
            strLists.add(new ArrayList<>(addNums));
            return;
        }
        String current = "";
        for (int i = start; i < strings.length; i++) {
            current = current + strings[i];
            boolean result = checkStr(current);
            if (!result) {
                continue;
            }
            sum += current.length();
            addNums.add(current);
            dfs(i + 1, strings, length);
            sum -= current.length();
            addNums.removeLast();
        }
    }

    public boolean checkStr(String str) {
        int length = str.length();
        int mid = length % 2;
        StringBuffer result1 = new StringBuffer();
        StringBuffer result2 = new StringBuffer();

        if (mid != 0) {
            result1.append(str.substring(0, (length / 2) ));
            result2.append(str.substring((length / 2)+1)).reverse();
        } else {
            result1.append(str.substring(0, (length / 2)));
            result2.append(str.substring((length / 2))).reverse();
        }
        return result2.toString().equals(result1.toString());
    }


    public static void main(String[] args) {
        Partition partition = new Partition();
        partition.partition("abbab");
    }
}
