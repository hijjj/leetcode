package huaweiOd;

import java.util.*;
//机器人仓库 good
public class RobotBricklaying {
    public void robotBricklaying(List<Integer> bricks) {
        if (bricks.size() > 8) {
            System.out.println(-1);
            return;
        }
        Collections.sort(bricks);
        int max = bricks.get(bricks.size() - 1);
        if (bricks.size() == 8) {
            System.out.println(max);
            return;
        }
        int min = 1;
        int result = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (check(mid, bricks, 8)) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(result);
    }

    public boolean check(int energy, List<Integer> bricks, int limit) {
        int cost = 0;
        for (int i = 0; i < bricks.size(); i++) {
            cost = cost + (bricks.get(i) / energy + (bricks.get(i) % energy == 0 ? 0 : 1));
        }
        return cost - limit <= 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        List<Integer> lists = new ArrayList<>();
        for (String str : strings) {
            lists.add(Integer.valueOf(str));
        }
        RobotBricklaying robotBricklaying = new RobotBricklaying();
        robotBricklaying.robotBricklaying(lists);
    }
}
