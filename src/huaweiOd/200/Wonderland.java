import java.util.Arrays;
import java.util.Scanner;
//Wonderland
public class Wonderland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] costs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] days = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 最大游玩日
        int maxDay = days[days.length - 1];

        // dp[i] 表示 前i天中完成其中所有游玩日需要的最少花费
        int[] dp = new int[maxDay + 1]; // dp[0] 默认为 0, 表示前0天花费0元

        // index用于指向当前需要完成的游玩日days[index]
        int index = 0;

        // 遍历第1天~第maxDay天
        for (int i = 1; i <= maxDay; i++) {

            if (i == days[index]) {
                // 如果第i天是游玩日，那么此时有四种花费选择

                // 选择买"一日票"，该花费仅用于第i天的游玩，那么此时前i天的花费就是 dp[i-1] + cost[0]
                int buy1 = dp[i - 1] + costs[0];

                // 选择买"三日票"，该花费可用于第i天，第i-1天，第i-2天（相当于在第i-2天购买），那么此时前i天的花费就是 dp[i-3] + cost[1]
                // 需要注意，如果 i < 3，那么dp[i-3]越界，此时前(i-3)天不存在,即花费为0
                int buy3 = (i >= 3 ? dp[i - 3] : 0) + costs[1];

                // 选择买“七日票”，该花费可用于第i天~第i-6天（相当于在第i-6天购买），那么此时前i天的花费就是 dp[i-7] + cost[2]
                // 同上，注意i<7的处理
                int buy7 = (i >= 7 ? dp[i - 7] : 0) + costs[2];

                // 选择买“月票”，该花费可用于第i天~第i-29天（相当于在第i-29天购买），那么此时前i天的花费就是 dp[i-30] + cost[3]
                // 同上，注意i<30的处理
                int buy30 = (i >= 30 ? dp[i - 30] : 0) + costs[3];

                // 最终dp[i]取上面四种花费的最小值
                dp[i] = Math.min(Math.min(Math.min(buy1, buy3), buy7), buy30);

                // 匹配下一个游玩日（days是升序的，因此index 和 days[index] 正相关）
                index++;
            } else {
                // 如果第i天不是游玩日，那么第i天不需要花费，即前i天的花费和前i-1天的花费一样
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(dp[maxDay]);
    }
}