package huaweiOd;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//模拟数据数据传输 50%
public class ChangeDate {
    static HashMap<String, String> changetype2num = new HashMap<>();
    static HashMap<String, String> changenum2type = new HashMap<>();
    static String str1 = "^\\d+$";
    static Pattern numToRegExp = Pattern.compile(str1);
    static String str2 = "^[0-9a-zA-Z\\s]+$";
    static Pattern strToRegExp = Pattern.compile(str2);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int case1 = Integer.valueOf(sc.nextLine());
        String str = sc.nextLine();
        setDateToMap();
        if (case1 == 1) {
            System.out.println(encode(str));
        } else if (case1 == 1) {
            try {
                System.out.println(decode(str));
            } catch (Exception e) {
                // 待解码字符串如果解码过程中发生了异常，则说明格式或者嵌套关系存在问题，则此时报错
                System.out.println("DECODE_ERROR");
            }
        }
    }

    private static void setDateToMap() {
        changetype2num.put("Integer", "0");
        changetype2num.put("String", "1");
        changetype2num.put("Compose", "2");
        changenum2type.put("0", "Integer");
        changenum2type.put("1", "String");
        changenum2type.put("2", "Compose");
    }

    public static boolean check_encode_str(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        char c1 = ']';
        char c2 = '[';
        int i = 0;
        if (build(str, i, c1, stack, c2)) return false;

        return stack.isEmpty();
    }

    private static boolean build(String str, int i, char c1, LinkedList<Character> stack, char c2) {
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == c1) {
                while (!stack.isEmpty() && stack.getLast() != c2) {
                    stack.removeLast();
                }
                if (stack.isEmpty()) {
                    return true;
                } else {
                    stack.removeLast();
                }

            } else {
                stack.addLast(c);
            }
            i++;
        }
        return false;
    }

    public static boolean check_encoded(String pos, String type, String data) {
        return check(pos, type, data);
    }

    private static boolean check(String pos, String type, String data) {
        if (!numToRegExp.matcher(pos).find()) {
            return false;
        }

        if (!changetype2num.containsKey(type)) {
            return false;
        }

        if ("Integer".equals(type)) {
            return numToRegExp.matcher(data).find();
        } else if ("String".equals(type)) {
            return strToRegExp.matcher(data).find();
        }

        return true;
    }

    // 编码
    public static String encode(String s) {
        String strs = "],\\[";
        String strs1 = "][";
        String str2 = "\\[";
        String str3 = "<";
        String str4 = "]";
        String str5 = ">";
        String str6 = "<([^<>]+)>";
        String str7 = "ENCODE_ERROR";
        s = s.replaceAll(strs, strs1);

        // 待编码字符串的格式校验
        if (!check_encode_str(s)) {
            return str7;
        }

        s = s.replaceAll(str2, str3).replaceAll(str4, str5);

        Pattern p = Pattern.compile(str6);

        s = getString(s, p);

        return s;
    }

    private static String getString(String s, Pattern p) {
        while (true) {
            Matcher m = p.matcher(s);
            if (!m.find()) break;
            String[] tmp = m.group(1).split(",");

            String pos = tmp[0];
            String type = tmp[1];
            String data = tmp[2];
            String encodeStr = "";

            if (check_encoded(pos, type, data)) {
                encodeStr = pos + "#" + changetype2num.get(type) + "#" + data.length() + "#" + data;
            }

            s = s.replace(m.group(0), encodeStr); // 将匹配到的内容 替换为 编码后的内容
        }
        return s;
    }

    public static boolean check_decoded(String pos, String type, String data) {
        if (!numToRegExp.matcher(pos).find()) {
            return false;
        }

        if (!changenum2type.containsKey(type)) {
            return false;
        }

        if ("0".equals(type)) {
            return numToRegExp.matcher(data).find();
        } else if ("1".equals(type)) {
            return strToRegExp.matcher(data).find();
        }

        return true;
    }


    // 解码
    public static String decode(String str) {
        LinkedList<String> queue = new LinkedList<>();
        Collections.addAll(queue, str.split("#"));

        StringJoiner res = new StringJoiner(",");

        while (!queue.isEmpty()) {
            String pos = queue.removeFirst();
            String type = queue.removeFirst();
            int len = Integer.parseInt(queue.removeFirst());

            // 剩余部分重新以#拼接
            String remain = String.join("#", queue);
            queue.clear();

            String data = remain.substring(0, len);

            if (remain.length() > len) {
                Collections.addAll(queue, remain.substring(len).split("#"));
            }

            if ("2".equals(type)) {
                data = decode(data);
            }

            if (check_decoded(pos, type, data)) {
                res.add("[" + pos + "," + changenum2type.get(type) + "," + data + "]");
            }
        }

        return res.toString();
    }
}