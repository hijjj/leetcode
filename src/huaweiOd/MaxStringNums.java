package huaweiOd;
//最长字符串的长度
public class MaxStringNums {
    public void maxStringNums(int num, String string) {
        if (num == 0) {
            System.out.println(string.length());
        }
        if (num % 2 == 0) {
            System.out.println(string.length());
        } else {
            System.out.println(string.length()-1);
        }
    }
}
