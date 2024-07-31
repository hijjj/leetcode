package huaweiOd;

import java.util.Scanner;

//最长字符串的长度 good
public class MaxStringNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str  = scanner.next();
        char[] c = str.toCharArray();
        int num =0;
        for(int i =0;i<c.length;i++){
            if(c[i]=='o'){
               num++;
            }
        }
        MaxStringNums maxStringNums = new MaxStringNums();
        maxStringNums.maxStringNums(num,str);
    }
    public void maxStringNums(int num, String string) {
        if (num == 0) {
            System.out.println(string.length());
            return;
        }
        if (num % 2 == 0) {
            System.out.println(string.length());
        } else {
            System.out.println(string.length()-1);
        }
    }
}
