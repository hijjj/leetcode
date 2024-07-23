package 字符串;

public class ReversalString2 {
    int start = 0;
    String newStr = "";

    public String reverseStr(String s, int k) {
        int end = start + 2 * k ;
        String str = null;
        while (end <= s.length()) {
            str = s.substring(start, end);
            String str1 = str.substring(0,k);
            String str2 = str.substring(k);
            char[] c = str1.toCharArray();
            reverseString(c);
            newStr = newStr + String.valueOf(c)+str2;
            start = end ;
            end = start + 2 * k;
        }
        if (start <= s.length()) {
            str = s.substring(start);
            if (str.length() < k) {
                char[] c = str.toCharArray();
                reverseString(c);
                newStr = newStr + String.valueOf(c);
            } else {
                String str2 = str.substring(0,k);
                char[] c1 = str2.toCharArray();
                reverseString(c1);
                newStr = newStr + String.valueOf(c1);
                String str3 = str.substring(k);
                newStr = newStr + str3;
            }
        }
        return newStr;
    }

    public void reverseString(char[] s) {
        int k = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[k];
            s[k] = tmp;
            k--;
        }
    }

    public static void main(String[] args) {
        ReversalString2 reversalString2 =new ReversalString2();
        reversalString2.reverseStr("abcdefg",2);
    }
}
