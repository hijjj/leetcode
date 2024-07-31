package huaweiOd;

import java.util.*;
import java.util.stream.Collectors;
//智能成绩 good
public class SmartScoreTable {
    public void smartScoreTable(List<String> lists) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer score1 = Integer.valueOf(o1.split("-")[1]);
                Integer score2 = Integer.valueOf(o2.split("-")[1]);
                if (score1.compareTo(score2) != 0) {
                    return score2.compareTo(score1);
                } else {
                    String name1 = o1.split("-")[0];
                    String name2 = o2.split("-")[0];
                    char[] c1 = name1.toCharArray();
                    char[] c2 = name2.toCharArray();
                    for (int i = 0; ; i++) {
                        if (c1.length > i && c2.length > i) {
                            if (c1[i] == c2[i]) {
                            } else {
                                return c2[i] - c1[i];
                            }
                        } else {
                            return c2.length - c1.length;
                        }
                    }
                }
            }
        };
        Collections.sort(lists, comparator);

        if (!lists.isEmpty()) {
            for(String str:lists){
                System.out.print(str.split("-")[0]+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int studentsNums = Integer.parseInt(line.split(" ")[0]);
        int projectNums = Integer.parseInt(line.split(" ")[1]);
        String line1 = scanner.nextLine();
        String[] line1s = line1.split(" ");
        List<String> projectLists = Arrays.asList(line1s);
        Map<String, List<Integer>> maps = new HashMap<>();
        for (int i = 0; i < studentsNums; i++) {
            String line2 = scanner.nextLine();
            String[] line2s = line2.split(" ");
            List<Integer> lists = new ArrayList<>();
            for (int j = 1; j < line2s.length; j++) {
                lists.add(Integer.valueOf(line2s[j]));
            }
            maps.put(line2s[0], lists);
        }
        String xueke = scanner.nextLine();
        SmartScoreTable smartScoreTable = new SmartScoreTable();
        List<String> lists2 = new ArrayList<>();
        if (!projectLists.contains(xueke)) {
            for (String key : maps.keySet()) {
                List<Integer> lists = maps.get(key);
                int count = lists.stream().mapToInt(u -> u).sum();
                String str = key + "-" + count;
                lists2.add(str);
            }
        } else {
            int i = 0;
            for (String str : projectLists) {
                if (xueke.equals(str)) {
                     break;
                }
            }
            for(String key:maps.keySet()){
                List<Integer> lists = maps.get(key);
                if(i>=lists.size()){
                    continue;
                }
                String str = key + "-" + lists.get(i);
                lists2.add(str);
            }
        }
        smartScoreTable.smartScoreTable(lists2);
    }
}
