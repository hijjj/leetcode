package huaweiOd;

import org.omg.CORBA.INV_FLAG;

import java.util.*;
//虚拟游戏
public class VirtualGame {
    public void virtualGame(int allMoneny, int recieveTask, int[] rebacks, int[] tasks, int[] monenys) {
        String result = "";
        Comparator<Map<String, Integer>> comparator = new Comparator<Map<String, Integer>>() {
            @Override
            public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
                Collection<Integer> value1 = o1.values();
                Integer reback1 = null;
                for (Integer i : value1) {
                    reback1 = i;
                }
                Collection<Integer> value2 = o2.values();
                Integer reback2 = null;
                for (Integer i : value2) {
                    reback2 = i;
                }
                return reback1.compareTo(reback2);
            }
        };
        PriorityQueue<Map<String, Integer>> priorityQueue = new PriorityQueue<>(comparator.reversed());
        for (int i = 0; i < rebacks.length; i++) {
            if (recieveTask >= tasks[i] && monenys[i] <= allMoneny) {
                Map<String, Integer> maps = new HashMap<>();
                maps.put(i + "" + ":" + monenys[i], rebacks[i] * monenys[i]);
                priorityQueue.add(maps);
            } else if (recieveTask >= tasks[i] && monenys[i] > allMoneny) {
                Map<String, Integer> maps = new HashMap<>();
                maps.put(i + "" + ":" + allMoneny, rebacks[i] * allMoneny);
                priorityQueue.add(maps);
            }
            for (int j = i + 1; j < rebacks.length; j++) {
                if (recieveTask >= tasks[i] + tasks[j]) {
                    List<Integer> rebackMoneny = new ArrayList<>();
                    int firstMoneny = monenys[i];
                    int secondMoneny = 0;
                    if (firstMoneny >= allMoneny) {
                        firstMoneny = allMoneny;
                    }
                    if (allMoneny - firstMoneny > monenys[j]) {
                        Map<String, Integer> maps = new HashMap<>();
                         maps.put(i + "-" + j + ":" +firstMoneny+","+monenys[j],rebacks[i] * firstMoneny + rebacks[j] * monenys[j]);
                         priorityQueue.add(maps);
                         continue;
                    }
                    for (int k = 1; k < firstMoneny; k++) {
                        secondMoneny = allMoneny - k;
                        if (secondMoneny <= monenys[j]) {
                            int rebackMonenys = rebacks[i] * firstMoneny + rebacks[j] * secondMoneny;
                            rebackMoneny.add(rebackMonenys);
                        }
                    }
                    Collections.sort(rebackMoneny);
                    Map<String, Integer> maps = new HashMap<>();
                    if (!rebackMoneny.isEmpty()) {
                        maps.put(i + "-" + j + ":" + firstMoneny + "," + secondMoneny, rebackMoneny.get(rebackMoneny.size() - 1));
                        priorityQueue.add(maps);
                    }
                }
            }
        }

        Map<String, Integer> maps111 = priorityQueue.poll();
        Set<String> keys = maps111.keySet();
        for (String str : keys) {
            String str1 = str.split(":")[0];
            String[] str2 = str1.split("-");
            Integer index1 = null;
            Integer index2 = null;
            if (str2.length == 2) {
                index2 = Integer.valueOf(str2[1]);
                index1 = Integer.valueOf(str2[0]);
            } else {
                index1 = Integer.valueOf(str2[0]);
            }
            String monenys1 = str.split(":")[1];
            String[] monenys2 = monenys1.split(",");
            String moneny1 = null;
            String moneny2 = null;
            if (str2.length == 2) {
                moneny1 = monenys2[0];
                moneny2 = monenys2[1];
            } else {
                moneny1 = monenys2[0];
            }
            if (index1 != null && index2 != null) {
                for (int i = 0; i < rebacks.length; i++) {
                    if (i == index1) {
                        result = result + moneny1 + " ";
                    } else if (i == index2) {
                        result = result + moneny2 + " ";
                    } else {
                        result = result + "0 ";
                    }
                }
            } else {
                for (int i = 0; i < rebacks.length; i++) {
                    if (i == index1) {
                        result = result + moneny1 + " ";
                    } else {
                        result = result + "0 ";
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line1 = scanner.nextLine();
//        String line2 = scanner.nextLine();
//        String line3 = scanner.nextLine();
//        String line4 = scanner.nextLine();
        VirtualGame virtualGame = new VirtualGame();
//        int allMoney = Integer.valueOf(line1.split(" ")[1]);
//        int allTasks =Integer.valueOf(line1.split(" ")[2]);
//        String[] strRebacks = line2.split(" ");
        int[] renacks = {10, 20, 30, 40, 50};
//        for(int i =0;i<strRebacks.length;i++){
//            renacks[i]= Integer.valueOf(strRebacks[i]);
//        }
//        String[] strTask = line3.split(" ");
        int[] tasks = {3, 4, 5, 6, 10};
//        for(int i =0;i<strTask.length;i++){
//            tasks[i]= Integer.valueOf(strTask[i]);
//        }

//        String[] strMonenys = line4.split(" ");
        int[] monenys = {20, 30, 20, 40, 30};
//        for(int i =0;i<strMonenys.length;i++){
//            monenys[i]= Integer.valueOf(strMonenys[i]);
//        }
        virtualGame.virtualGame(100, 10, renacks, tasks, monenys);
    }
}
