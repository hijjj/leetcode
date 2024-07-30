package huaweiOd;

import java.util.*;

//CPU算力分配
public class Cpu {
    public void cpu(int[] a, int[] b) {
        List<String> lists = new ArrayList<>();
        int counta = 0;
        for (int i = 0; i < a.length; i++) {
            counta = counta + a[i];
        }
        int countb = 0;
        for (int j = 0; j < b.length; j++) {
            countb = countb + b[j];
        }
        int tmpa = 0;
        int tmpb = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                tmpa = counta;
                tmpb = countb;
                counta = counta - a[i] + b[j];
                countb = countb - b[j] + a[i];
                if (countb == counta) {
                    lists.add(a[i] + "-" + b[j]);
                } else {
                    counta = tmpa;
                    countb = tmpb;
                }
            }
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer str1 = Integer.valueOf(o1.split("-")[0]);
                Integer str2 = Integer.valueOf(o2.split("-")[0]);
                return str1.compareTo(str2);
            }
        };
        Collections.sort(lists, comparator);

        String str = lists.get(0);

        String[] strings = str.split("-");

        System.out.println(strings[0] + " " + strings[1]);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();
        String line3 =scanner.nextLine();
        String[] string2 = line2.split(" ");
        String[] strings3 = line3.split(" ");
        int[] strs2 = new int[string2.length];
        int[] strs3 = new int[strings3.length];
        for(int i =0;i<string2.length;i++){
            strs2[i] = Integer.valueOf(string2[i]);
        }
        for(int i =0;i<strings3.length;i++){
            strs3[i] = Integer.valueOf(strings3[i]);
        }
        Cpu cpu = new Cpu();
        cpu.cpu(strs2,strs3);
    }
}
