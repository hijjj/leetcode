package huaweiOd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//万能单词拼写 good
public class StringWords {
    public void stringWords(String[] words, List<String> charsLists, int nums) {
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            int nums1 = nums;
            List<String> newCharLists = new ArrayList<>(charsLists);
            boolean result = false;
            String word = words[i];
            String[] wordStrs = word.split("");
            for (String string : wordStrs) {
                if (newCharLists.contains(string)) {
                    result = true;
                    newCharLists.remove(string);
                    continue;
                } else {
                    if (nums1 > 0) {
                        result = true;
                        nums1--;
                        continue;
                    }
                    result = false;
                    break;
                }
            }
            if (result) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
//        StringWords stringWords = new StringWords();
//        String[] strings = {"cat", "bt", "hat","tree" };
//        String string1 = "atachh??";
//        String[] string1s = string1.split("");
//        List<String> lists =Arrays.asList(string1s);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> lists = new ArrayList<>();
        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = scanner.next();
        }
        String string = scanner.next();
        StringWords stringWords = new StringWords();
        String[] s= string.split("");
            int num2=0;
            for(String string1:s){
                if("?".equals(string1)){
                    num2++;
                }
            }
            stringWords.stringWords(strings,  Arrays.asList(s), num2);
        }
}
