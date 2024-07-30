package huaweiOd;

import java.util.*;
//开源项目
public class OpenProject {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        Scanner scanner1 = new Scanner(System.in);
//
//        String weights = scanner1.nextLine();
//        List<String> projectLists = new ArrayList<>();
//        for (int i = 1; i <= num; i++) {
//            Scanner scanner3 = new Scanner(System.in);
//            projectLists.add(scanner3.nextLine());
//        }
//
//        String[] weightss = weights.split(" ");
//        int[] weight = new int[weights.length()];
//        for (int i = 0; i < weightss.length; i++) {
//            weight[i] = Integer.valueOf(weightss[i]);
//        }
//        Map<String,List<Integer>> webScore = new HashMap<>();
//        for (String str : projectLists) {
//             String[] strings= str.split(" ");
//             String key = strings[0];
//             List<Integer> lists = new ArrayList<>();
//             for(int i =1;i<strings.length;i++){
//                 lists.add(Integer.valueOf(strings[i]));
//             }
//            webScore.put(key,lists);
//        }
        OpenProject openProject = new OpenProject();
        int[] weight = {5,6,6,1,2};
        Map<String,List<Integer>> maps = new HashMap<>();
        List<Integer> lists1 = new ArrayList<>();
        lists1.add(13);
        lists1.add(88);
        lists1.add(46);
        lists1.add(26);
        lists1.add(169);

        maps.put("camila",lists1);

        List<Integer> lists2 = new ArrayList<>();
        lists2.add(64);
        lists2.add(38);
        lists2.add(87);
        lists2.add(23);
        lists2.add(103);
        maps.put("grace",lists2);

        List<Integer> lists3 = new ArrayList<>();
        lists3.add(91);
        lists3.add(79);
        lists3.add(98);
        lists3.add(154);
        lists3.add(79);
        maps.put("lucas",lists3);

        List<Integer> lists4 = new ArrayList<>();
        lists4.add(29);
        lists4.add(27);
        lists4.add(36);
        lists4.add(43);
        lists4.add(178);
        maps.put("leo",lists4);
        List<Integer> lists5 = new ArrayList<>();
        lists5.add(29);
        lists5.add(27);
        lists5.add(36);
        lists5.add(43);
        lists5.add(178);
        maps.put("leop",lists5);
        openProject.sortProjects(weight,maps);
        Object o = new Object();
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
                if (score2.compareTo(score1)!=0) {
                    return score2-score1;
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
