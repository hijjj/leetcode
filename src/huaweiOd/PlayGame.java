package huaweiOd;

import java.util.*;

//王者荣耀 good
public class PlayGame {
    LinkedList<Integer> addNums = new LinkedList<>();
    List<Integer> result = new LinkedList<>();

    public void playGame(List<Integer> lists, int start, int num, int total) {
        if (addNums.size() == num) {
            int sum = addNums.stream().mapToInt(u -> u).sum();
            result.add(Math.abs(total - sum-sum));
            return;
        }
        for (int i = start; i < lists.size(); i++) {
            addNums.add(lists.get(i));
            playGame(lists, i+1, num, total);
            addNums.removeLast();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lists = new ArrayList<>();
        String[] nums = scanner.nextLine().split(" ");

        for (String str : nums) {
            lists.add(Integer.valueOf(str));
        }
        int num = lists.size();

        int total = lists.stream().mapToInt(u->u).sum();

        PlayGame playGame = new PlayGame();
        playGame.playGame(lists,0,num/2,total);
        Collections.sort(playGame.result);
        System.out.println(playGame.result.get(0));
    }

}
