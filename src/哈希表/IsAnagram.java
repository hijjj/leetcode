package 哈希表;

public class IsAnagram {
    int[] record = new int[26];

    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (char c : chars1) {
            record[c - 'a']++;
        }
        for (char c : chars2) {
            record[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
