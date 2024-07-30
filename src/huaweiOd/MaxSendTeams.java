package huaweiOd;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//最多派遣多少个队伍
public class MaxSendTeams {
    public void maxSendTeams(int min, List<Integer> abilitys) {
        int sum = 0;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        Collections.sort(abilitys, comparator);
        for (int i = 0; i < abilitys.size(); ) {
            if (abilitys.get(i) >= min) {
                sum++;
                i++;
            } else {
                int abilityNum =0;
                if (i + 1 < abilitys.size()) {
                     abilityNum = abilitys.get(i) + abilitys.get(i + 1);
                }else {
                    break;
                }
                if (abilityNum >= min) {
                    sum++;
                    i++;
                } else {
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        MaxSendTeams maxSendTeams = new MaxSendTeams();
        Integer[] nums = {3, 1, 5, 7, 9};
        maxSendTeams.maxSendTeams(4, Arrays.asList(nums));
    }
}
