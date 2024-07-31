package huaweiOd;

import java.util.*;

//开源项目 good
public class OpenProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] weight = new int[5];
        for (int i = 0; i < 5; i++) {
            weight[i] = scanner.nextInt();
        }
        List<String> projectLists = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            String name = scanner.next();
            String num1 = " " + String.valueOf(scanner.nextInt());
            String num2 = " " + String.valueOf(scanner.nextInt());
            String num3 = " " + String.valueOf(scanner.nextInt());
            String num4 = " " + String.valueOf(scanner.nextInt());
            String num5 = " " + String.valueOf(scanner.nextInt());
            projectLists.add(name + num1 + num2 + num3 + num4 + num5);
        }

        Map<String, List<Integer>> webScore = new HashMap<>();
        for (String str : projectLists) {
            String[] strings = str.split(" ");
            String key = strings[0];
            List<Integer> lists = new ArrayList<>();
            for (int i = 1; i < strings.length; i++) {
                lists.add(Integer.valueOf(strings[i]));
            }
            webScore.put(key, lists);
        }
        OpenProject openProject = new OpenProject();
        openProject.sortProjects(weight, webScore);
    }

    public void sortProjects(int[] weight, Map<String, List<Integer>> webScore) {
        Comparator<Map<String, Integer>> comparator = new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                Integer score1 = null;
                for (Integer score : o1.values()) {
                    score1 = score;
                }
                Integer score2 = null;
                for (Integer score : o2.values()) {
                    score2 = score;
                }
                if (score2.compareTo(score1) != 0) {
                    return score2 - score1;
                }
                String key1 = null;
                for (String key : o1.keySet()) {
                    key1 = key;
                }
                String key2 = null;
                for (String key : o2.keySet()) {
                    key2 = key;
                }
                char[] c1 = key1.toCharArray();
                char[] c2 = key2.toCharArray();
                int length = 0;
                while (length < c1.length && length < c2.length) {
                    if (c1[length] != c2[length]) {
                        return c1[length] - c2[length];
                    }
                    length++;
                    if (length == c1.length) {
                        return -1;
                    }
                    if (length == c2.length) {
                        return 1;
                    }
                }

                return 0;
            }
        };
        PriorityQueue<Map<String, Integer>> priorityQueue = new PriorityQueue<>(comparator);
        for (String key : webScore.keySet()) {
            List<Integer> scoreLists = webScore.get(key);
            Map<String, Integer> webSumScore = new HashMap<>();
            int i = 0;
            int sum = 0;
            for (Integer score : scoreLists) {
                int sumScore = score * weight[i];
                i++;
                sum = sum + sumScore;
            }
            webSumScore.put(key, sum);
            priorityQueue.add(webSumScore);
        }
        while (!priorityQueue.isEmpty()) {
            Map<String, Integer> maps = priorityQueue.poll();
            for (String str : maps.keySet()) {
                System.out.println(str);
            }
        }
    }
}
