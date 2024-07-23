package 动态规划;

/**
 * 正则表达式匹配
 */
public class Matchs {
    boolean[][] result;

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        result = new boolean[sl + 1][pl + 1];
        result[0][0] = true;
        for (int i = 1; i < sl; i++) {
            for (int j = 0; j < pl; ++j) {
                if (p.charAt(j) == '*') {
                    result[i][j] = result[i][j - 2];
                    if (isMatch(i, j - 1, p, s)) {
                        result[i][j] = result[i][j] || result[i][j - 2];
                    }
                } else {
                    if (isMatch(i, j, p, s)) {
                        result[i][j] = result[i - 1][j - 1];
                    }
                }
            }
        }
return result[sl][pl];
    }

    public boolean isMatch(int i, int j, String p, String s) {
        if (i < 0) {
            return false;
        }
        if (p.charAt(j) == '.') {
            return true;
        }
        return s.charAt(i) == s.charAt(j);
    }
}
