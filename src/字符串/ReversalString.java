package 字符串;

import java.util.Arrays;

public class ReversalString {
    public void reverseString(char[] s) {
        int k = s.length-1;
        for(int i =0;i<s.length/2;i++){
            char tmp = s[i];
            s[i] = s[k];
            s[k] = tmp;
            k--;
        }
    }

    public static void main(String[] args) {
        ReversalString reversalString =new ReversalString();
        char[] s = {'h','e','l','q','l','o'};
        reversalString.reverseString(s);
    }
}
