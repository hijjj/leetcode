package 回溯;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinations {
    List<String> numbers = new ArrayList<>();

    LinkedList<String> linkedLists = new LinkedList<>();

    Map<String, List<String>> allMaps = new HashMap<>();
    int j = 0;

    public List<String> letterCombinations(String digits) {
        List<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        list2.add("c");

        allMaps.put("2", list2);

        List<String> list3 = new ArrayList<>();
        list3.add("d");
        list3.add("f");
        list3.add("e");

        allMaps.put("3", list3);

        List<String> list4 = new ArrayList<>();
        list4.add("g");
        list4.add("i");
        list4.add("h");

        allMaps.put("4", list4);

        List<String> list5 = new ArrayList<>();
        list5.add("j");
        list5.add("l");
        list5.add("k");

        allMaps.put("5", list5);
        List<String> list6 = new ArrayList<>();
        list6.add("m");
        list6.add("0");
        list6.add("n");

        allMaps.put("6", list6);

        List<String> list7 = new ArrayList<>();
        list7.add("p");
        list7.add("r");
        list7.add("q");
        list7.add("s");

        allMaps.put("7", list7);

        List<String> list8 = new ArrayList<>();
        list8.add("t");
        list8.add("v");
        list8.add("u");

        allMaps.put("8", list8);

        List<String> list9 = new ArrayList<>();
        list9.add("w");
        list9.add("y");
        list9.add("x");
        list9.add("z");
        allMaps.put("9", list9);
        if("".equals(digits)){
            return numbers;
        }
        String[] strings = digits.split("");

        letterCombinations(0, strings);

        return numbers;
    }

    public void letterCombinations(int i, String[] strings) {
        if (linkedLists.size() == strings.length) {
            numbers.add(linkedLists.stream().collect(Collectors.joining()));
            i--;
            return;
        }
        List<String> dataLists = allMaps.get(strings[i]);
        for (int j = 0; j < dataLists.size(); j++) {
            linkedLists.add(dataLists.get(j));
            letterCombinations(i + 1, strings);
            linkedLists.removeLast();

        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        letterCombinations.letterCombinations("");
    }
}
