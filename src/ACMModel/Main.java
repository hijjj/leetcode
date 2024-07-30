package ACMModel;

import java.util.*;


public class Main {
    static int count=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.valueOf(in.nextLine());
        init(n);
        System.out.println(count);

    }
    static void init(int max){
        int idx=max;
        while(idx>0){
            idx = check(idx);
            count++;
            idx--;
        }

    }
    static int check(int num){
        int res =num;
        String str = String.valueOf(num).replace("4","3");
        return Integer.valueOf(str);
    }
}