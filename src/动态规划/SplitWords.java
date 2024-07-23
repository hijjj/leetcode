package 动态规划;

import java.util.Arrays;
import java.util.List;

public class SplitWords {
    boolean[][] dp;
    int start;
    int end;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()][wordDict.size()];
        Arrays.fill(dp[0], true);
        for (int i = 0; i < wordDict.size(); i++) {
            String str = wordDict.get(i);
            String str2;
            if (i == 0) {
                str2 = s.substring(0, str.length());
                end = s.length();
            } else {
                str2 = s.substring(end + 1, str.length());
                end = end + str.length();
            }
            if (str == str2) {
                dp[s.length()][i] = dp[s.length() - str.length()][i];
            }
        }
        return dp[s.length()-1][wordDict.size()-1];
    }
}
