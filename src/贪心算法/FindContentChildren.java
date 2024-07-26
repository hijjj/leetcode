package 贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContentChildren {

    int num = 0;

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = start; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    start++;
                    num++;
                    break;
                }
            }
        }
        return num;
    }


}
