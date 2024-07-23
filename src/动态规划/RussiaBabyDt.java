package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class RussiaBabyDt {
    int[][] nums;
    public int maxEnvelopes(int[][] envelopes) {
        nums = new int[envelopes.length][envelopes[0].length];
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        return max(envelopes);
    }

    public int max(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        RussiaBabyDt russiaBaby = new RussiaBabyDt();
        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        russiaBaby.maxEnvelopes(envelopes);
    }
}
